package br.edu.unoesc.desafiofullstack.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.unoesc.desafiofullstack.Autenticacao.AutenticacaoService;
import br.edu.unoesc.desafiofullstack.Entidades.EnderecoPessoa;
import br.edu.unoesc.desafiofullstack.Record.EnderecoPessoaRecord;
import br.edu.unoesc.desafiofullstack.Repositories.CadastroEndRepository;
import br.edu.unoesc.desafiofullstack.Service.ViaCepResponse;
import br.edu.unoesc.desafiofullstack.Service.ViaCepService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CadastroEndController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private CadastroEndRepository cadastroEndRepository;

    @GetMapping("/pessoa/{id}/cadastroEndereco")
    public String endereco(@PathVariable String id, HttpSession session, Model model) {
        // Verifica se o usuário está logado
        if (autenticacaoService.isUsuarioLogado(session)) {

            // Long idpessoa = Long.parseLong(id);
            // Optional<Pessoa> infoContato =
            // contatoPessoaRepository.findByIdpessoa(idpessoa);

            // model.addAttribute("infoContato", infoContato);

            return "cadastroEndereco";
        } else {
            return "redirect:/login";
        }

    }

    @PostMapping("/pessoa/{id}/cadastroEndereco")
    public String adicionarEndereco(@PathVariable Long id, EnderecoPessoaRecord dados,
            HttpSession session, Model model) {

        EnderecoPessoaRecord endereco = new EnderecoPessoaRecord(dados.CadastroCEP(), dados.CadastroLogradouro(),
                dados.CadastroNumero(), dados.CadastroBairro(), dados.CadastroMunicipio(), dados.CadastroEstado(), id);
        // Crie e associe o membro ao trabalho e ao usuário
        var enderecoCad = new EnderecoPessoa(endereco);

        cadastroEndRepository.save(enderecoCad);

        return "redirect:/pessoa/" + id + "/cadastroEndereco";
    }

    private final ViaCepService viaCepService;

    public CadastroEndController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @PostMapping("/buscarCEP")
    public ResponseEntity<ViaCepResponse> buscarCEP(@RequestParam String CEP) {
        ViaCepResponse resposta = viaCepService.consultarCEP(CEP);
        return ResponseEntity.ok(resposta);
    }
}
