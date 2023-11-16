package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.ContatoPessoa;
import br.edu.unoesc.desafiofullstack.Record.ContatoPessoaRecord;
import br.edu.unoesc.desafiofullstack.Repositories.ContatoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class CadastroContatoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoPessoaRepository contatoPessoaRepository;

    @GetMapping("/pessoa/{id}/cadastroContato")
    public String contatos(@PathVariable String id, HttpSession session, Model model) {
        // Verifica se o usuário está logado
        if (autenticacaoService.isUsuarioLogado(session)) {

            // Long idpessoa = Long.parseLong(id);
            // Optional<Pessoa> infoContato =
            // contatoPessoaRepository.findByIdpessoa(idpessoa);

            // model.addAttribute("infoContato", infoContato);

            return "cadastroContato";
        } else {
            return "redirect:/login";
        }

    }

    @PostMapping("/pessoa/{id}/cadastroContato")
    public String adicionarContato(@PathVariable Long id, ContatoPessoaRecord dados, HttpSession session, Model model) {

        ContatoPessoaRecord contato = new ContatoPessoaRecord(dados.CadastroTelefone(), dados.CadastroEmail(), id);
        // Crie e associe o membro ao trabalho e ao usuário
        var contatoCad = new ContatoPessoa(contato);

        contatoPessoaRepository.save(contatoCad);

        return "redirect:/pessoa/" + id + "/cadastroContato";
    }
}
