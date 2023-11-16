package br.edu.unoesc.desafiofullstack.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.ContatoPessoa;
import br.edu.unoesc.desafiofullstack.Entidades.EnderecoPessoa;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Repositories.ContatoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.EnderecoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class PessoaControler {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoPessoaRepository contatoPessoaRepository;

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    @GetMapping("/pessoa/{id}")
    public String pessoa(@PathVariable Long id, HttpSession session, Model model) {
        // Verifica se o usuário está logado
        if (autenticacaoService.isUsuarioLogado(session)) {

            Pessoa infoPessoa = pessoaRepository.findById(id).orElse(null);
            model.addAttribute("infoPessoa", infoPessoa);

            List<ContatoPessoa> infoContato = contatoPessoaRepository.findByIdpessoa(id);
            model.addAttribute("infoContato", infoContato);

            List<EnderecoPessoa> infoEndereco = enderecoPessoaRepository.findByIdPessoa(id);
            model.addAttribute("infoEndereco", infoEndereco);

            return "pessoa";
        } else {
            return "redirect:/login";
        }

    }






}
