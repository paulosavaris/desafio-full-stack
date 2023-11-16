package br.edu.unoesc.desafiofullstack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // Verifica se o usuário está logado
        if (autenticacaoService.isUsuarioLogado(session)) {

            List<Pessoa> pessoas = pessoaRepository.findAll();
            model.addAttribute("pessoas", pessoas);

            return "home";
        } else {
            return "redirect:/login";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Finaliza a sessão atual
        request.getSession().invalidate();

        // Redireciona para a página de login ou qualquer outra página
        return "redirect:/login";
    }
}
