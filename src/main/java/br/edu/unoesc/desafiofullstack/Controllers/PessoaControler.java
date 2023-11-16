package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class PessoaControler {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa/{id}")
    public String pessoa(@PathVariable String id, HttpSession session, Model model) {
        // Verifica se o usuário está logado
        if (autenticacaoService.isUsuarioLogado(session)) {

            Long idpessoa = Long.parseLong(id);
            Pessoa infoPessoa = pessoaRepository.findById(idpessoa).orElse(null);
            model.addAttribute("infoPessoa", infoPessoa);

            return "pessoa";
        } else {
            return "redirect:/login";
        }

    }
}
