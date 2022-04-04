package br.natan.VenturaHR.Controller;

import br.natan.VenturaHR.Model.Domain.Empresa;
import br.natan.VenturaHR.Model.Domain.Usuario;
import br.natan.VenturaHR.Model.Domain.Vaga;
import br.natan.VenturaHR.Model.Service.EmpresaService;
import br.natan.VenturaHR.Model.Service.UsuarioService;
import br.natan.VenturaHR.Model.Service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private VagaService vagaService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/empresas")
    public String telaEmpresas(Model model, @SessionAttribute("user")Usuario usuario) {
        model.addAttribute("empresaLista", empresaService.obterLista());
        model.addAttribute("usuarioId", usuario.getId());
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getId());
        return "empresa/empresas";
    }
    @GetMapping(value = "/empresa/cadastro")
    public String telaCadastroEmpresa(Model model,@SessionAttribute("user") Usuario usuario) {
        return "/empresa/cadastro";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/empresa/cadastro")
    public String cadastrarEmpresa(Model model,@SessionAttribute("user") Usuario usuario, Empresa empresa){
        try{
            System.out.println(usuario.getEmail());
            empresa.setUsuario(usuario);
            empresa.setIdUsuarioCriador(usuario.getId());
            empresaService.incluir(empresa);
            System.out.println("Empresa cadastrada com sucesso " + empresa.getEmail());
            return telaEmpresas(model,usuario);
        }catch (Exception e){
            System.out.println("Falha ao cadastrar empresa " + empresa.getEmail());
            return telaCadastroEmpresa(model,usuario);
        }
    }
    @GetMapping(value = "/empresa/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        empresaService.excluir(id);
        return "redirect:/empresas";
    }
}
