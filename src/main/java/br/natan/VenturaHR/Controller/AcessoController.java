package br.natan.VenturaHR.Controller;

import br.natan.VenturaHR.Model.Domain.Usuario;
import br.natan.VenturaHR.Model.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AcessoController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/")
    public String telaLogin(){
        return "usuario/login";
    }

    @GetMapping(value = "/home")
    public String telaHome() {
        return "usuario/index";
    }

    @PostMapping(value = "/login")
    public String usuarioLogin(Model model, @RequestParam String email, @RequestParam String senha){
        System.out.println(email +" "+ senha);
        Usuario usuario = usuarioService.loginUser(email,senha);
        if(usuario != null) {
            model.addAttribute("user", usuario);
            model.addAttribute(
                    "mensagem",
                    "Login realizado com sucesso!!"
            );
            return telaHome();
        } else {
            model.addAttribute(
                    "mensagem",
                    "As credenciais do usuário "+ email +" estão incorretas!!!"
            );
            return telaLogin();
        }

    }
    @GetMapping(value = "/logout")
    public String logout(SessionStatus status, HttpSession session) {

        status.setComplete();
        session.removeAttribute("user");

        return "redirect:/";
    }
    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {
        return "/usuario/cadastro";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/usuario/cadastro")
    public String cadastrarUsuario(Model model, Usuario usuario){
        Usuario usuarioCadastrado = usuarioService.obterPorEmail(usuario.getEmail());
        if (usuarioCadastrado == null){
            try{
                usuarioService.incluir(usuario);
                System.out.println("Usuario cadastrado com sucesso " + usuario.getEmail());
                model.addAttribute("mensagem", "Usuário Cadastrado com sucesso!");
                return telaLogin();
            }catch (Exception e){
                System.out.println("Falha ao cadastrar usuario " + usuario.getEmail());
                model.addAttribute("mensagem", "Dados inseridos incorretamente!");
                return telaCadastro();
            }
        }else{
            System.out.println("Usuario com este email ja existe " + usuario.getEmail());
            model.addAttribute("mensagem", "Usuario com este email ja existe");
            return telaCadastro();
        }
    }
}
