package br.natan.VenturaHR.Controller;

import br.natan.VenturaHR.Model.Domain.Empresa;
import br.natan.VenturaHR.Model.Domain.Resposta;
import br.natan.VenturaHR.Model.Domain.Usuario;
import br.natan.VenturaHR.Model.Domain.Vaga;
import br.natan.VenturaHR.Model.Service.EmpresaService;
import br.natan.VenturaHR.Model.Service.RespostaService;
import br.natan.VenturaHR.Model.Service.UsuarioService;
import br.natan.VenturaHR.Model.Service.VagaService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class VagaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private VagaService vagaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RespostaService respostaService;


    @GetMapping(value = "/empresa/{id}/vaga/{idvaga}/candidatos")
    public String telaCandidatos(Model model, @SessionAttribute("user") Usuario usuario, @PathVariable Integer id, @PathVariable Integer idvaga){
        Collection<Resposta> respostas = respostaService.obterListaPorVaga(idvaga);
        System.out.println("Numero de Respostas "+respostas.size());
        Collection<Usuario> usuarios = new ArrayList<>();
        for (Resposta resposta: respostas) {
            System.out.println(resposta.getVaga().getCargo());
            System.out.println(usuarioService.obterPorId(resposta.getId_Usuario()).getEmail());
            usuarios.add(usuarioService.obterPorId(resposta.getId_Usuario()));
        }
        System.out.println(usuarios.size());
        model.addAttribute("listaUsuario", usuarios);
        model.addAttribute("nomeVaga", vagaService.obterPorId(idvaga).getCargo());

        model.addAttribute("usuarioId", usuario.getId());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getId());
        return "vaga/candidatos";
    }

    @GetMapping(value = "/vagas")
    public String telaVagas(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("vagaLista", vagaService.obterLista());
        model.addAttribute("usuarioId", usuario.getId());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getId());
        return "vaga/vagas";
    }
    @GetMapping(value = "/empresa/{id}/vagas")
    public String telaVagasDaEmpresa(Model model, @SessionAttribute("user") Usuario usuario,@PathVariable Integer id) {
        Empresa empresa = empresaService.obterPorId(id);
        model.addAttribute("idEmpresa", empresa.getId());
        model.addAttribute("vagaLista", vagaService.obterListaPorEmpresa(id));
        model.addAttribute("usuarioId", usuario.getId());
        model.addAttribute("nomeEmpresa", empresa.getNome());
        model.addAttribute("criadorEmpresa", empresa.getIdUsuarioCriador());
        return "vaga/vagas";
    }
    @GetMapping(value = "/empresa/{id}/vaga/cadastro")
    public String telaCadastroVagas(Model model,@SessionAttribute("user") Usuario usuario,@PathVariable Integer id) {
        model.addAttribute("idEmpresa", id);
        return "vaga/cadastro";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/empresa/{id}/vaga/cadastro")
    public String cadastrarVaga(Model model,@SessionAttribute("user") Usuario usuario,Vaga vaga,@PathVariable Integer id){
        try{
            System.out.println(id);
            System.out.println(usuario.getEmail());
            Empresa empresa = empresaService.obterPorId(id);
            System.out.println(empresa.getNome());
            vaga.setEmpresa(empresa);
            vaga.setNomeEmpresa(empresa.getNome());
            vaga.setIdUsuarioCriador(usuario.getId());
            vaga.setEmpresaCriadora(id);
            vagaService.incluir(vaga);
            System.out.println("Vaga cadastrada com sucesso " + vaga.getCargo());
            return telaVagasDaEmpresa(model,usuario,id);
        }catch (Exception e){
            System.out.println("Falha ao cadastrar Vaga " + vaga.getCargo());
            return telaCadastroVagas(model,usuario,id);
        }
    }
    @GetMapping(value = "/vaga/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        empresaService.excluir(id);
        return "redirect:/empresas";
    }




    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/empresa/{id}/vaga/{idvaga}/candidato")
    public String cadastrarResposta(Model model,@SessionAttribute("user") Usuario usuario,@PathVariable Integer id,@PathVariable Integer idvaga){
        try{
            System.out.println("Comecando a cadastrar usuario na vaga... ");
            Vaga vaga = vagaService.obterPorId(idvaga);
            System.out.println(vaga.getCargo());
            Resposta resposta = new Resposta();
            resposta.setVaga(vaga);
            resposta.setId_Vaga(idvaga);
            resposta.setDatatime(DateTime.now().toString());
            System.out.println(resposta.getDatatime());
            resposta.setId_Usuario(usuario.getId());
            respostaService.incluir(resposta);
            model.addAttribute("mensagem", "Candidatura realizada com sucesso!");
            System.out.println("Usuario cadastrada com sucesso na vaga" + resposta.getId());
            System.out.println("Usuario " + resposta.getId_Usuario());
            return telaVagasDaEmpresa(model,usuario,id);
        }catch (Exception e){
            System.out.println("Falha ao cadastrar Vaga ");
            return telaVagasDaEmpresa(model,usuario,id);
        }
    }
//    @GetMapping(value = "/empresa/{id}/vaga/{idvaga}/excluir")
//    public String excluirResposta(@PathVariable Integer id) {
//        empresaService.excluir(id);
//        return "redirect:/empresas";
//    }
}
