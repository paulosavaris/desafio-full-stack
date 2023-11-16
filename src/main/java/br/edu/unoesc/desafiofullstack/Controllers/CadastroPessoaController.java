package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Record.PessoaRecord;
import br.edu.unoesc.desafiofullstack.Repositories.ContatoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cadastroPessoas")
public class CadastroPessoaController {

    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ContatoPessoaRepository contatoPessoaRepository;

    @GetMapping
    public String CadPessoa(HttpSession session) {
        if (autenticacaoService.isUsuarioLogado(session)) {
            return "cadastroPessoas";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping(params = "formAction=cadastra")
    public String cadastraPessoa(PessoaRecord dados, HttpSession session) {
        if (autenticacaoService.isUsuarioLogado(session)) {

            var cadastroPessoa = new Pessoa(dados);

            pessoaRepository.save(cadastroPessoa);

            return "cadastroPessoas";
        } else {
            return "redirect:/login";
        }
    }
}