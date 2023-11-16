package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Record.PessoaRecord;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cadastroPessoas")
public class CadastroPessoaController {

    @Autowired
    private AutenticacaoService autenticacaoService;
    @Autowired
    private PessoaRepository pessoaRepository;
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

            if (pessoaRepository.existsByCPF(dados.CadastroCPF())) {
                return "redirect:/cadastroPessoas?errorC=CPF já cadastrado";
            }
            var cadastroPessoa = new Pessoa(dados);

            pessoaRepository.save(cadastroPessoa);
            // Definir um atributo de sessão para indicar que o cadastro foi bem-sucedido
            session.setAttribute("cadastroSucesso", "Usuário cadastrado com sucesso!");
            return "cadastroPessoas";

        } else {
            return "redirect:/login";
        }
    }
}