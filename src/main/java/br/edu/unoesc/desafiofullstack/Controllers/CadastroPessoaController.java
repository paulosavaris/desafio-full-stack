package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cadastroPessoas")
public class CadastroPessoaController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @GetMapping
    public String carregaPagLogin(HttpSession session) {
        if (autenticacaoService.isUsuarioLogado(session)) {
            return "cadastroPessoas";
        } else {
            return "redirect:/login";
        }
    }
}
