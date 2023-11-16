package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.unoesc.desafiofullstack.Entidades.Usuario;
import br.edu.unoesc.desafiofullstack.Repositories.UsuariosRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public String carregaPagLogin() {
        return "login";
    }

    @PostMapping(params = "formAction=login")
    public String realizaLogin(@RequestParam("FormLoginEmail") String FormLoginEmail,
            @RequestParam("FormLoginPassword") String FormLoginPassword,
            HttpSession session) {
        Usuario usuario = repository.findByEmailAndSenha(FormLoginEmail, FormLoginPassword);

        if (usuario != null) {
            // Login bem-sucedido, armazene informações do usuário na sessão
            session.setAttribute("usuarioLogado", usuario);
            session.setAttribute("idUsuarioLogado", usuario.getId());

            // Redirecione para a página após o login bem-sucedido
            return "redirect:/home";
        } else {
            return "redirect:/login?errorL=Email ou senha incorretos";
        }

    }

}
