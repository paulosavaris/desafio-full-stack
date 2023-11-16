package br.edu.unoesc.desafiofullstack.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.desafiofullstack.Entidades.ContatoPessoa;
import br.edu.unoesc.desafiofullstack.Entidades.EnderecoPessoa;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;
import br.edu.unoesc.desafiofullstack.Repositories.ContatoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.EnderecoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.PessoaRepository;
import br.edu.unoesc.desafiofullstack.Service.ContatoService;
import br.edu.unoesc.desafiofullstack.Service.EnderecoService;

@Controller
public class DeleteController {

    @Autowired
    private EnderecoPessoaRepository enderecoPessoaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContatoPessoaRepository contatoPessoaRepository;

    @PostMapping("/removeEnd/{endId}")
    @ResponseBody
    public ResponseEntity<String> removeEnd(@PathVariable Long endId) {
        // Lógica para exclusão com base no memberId e workId recebidos
        Optional<EnderecoPessoa> endOptional = enderecoPessoaRepository.findById(endId);

        if (endOptional.isPresent()) {
            // Se o membro existe, remova-o do banco de dados
            enderecoPessoaRepository.delete(endOptional.get());
            return new ResponseEntity<>("Endereco removido com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Endereco não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/removeContato/{contatoId}")
    @ResponseBody
    public ResponseEntity<String> removeContato(@PathVariable Long contatoId) {
        // Lógica para exclusão com base no memberId e workId recebidos
        Optional<ContatoPessoa> contOptional = contatoPessoaRepository.findById(contatoId);

        if (contOptional.isPresent()) {
            // Se o membro existe, remova-o do banco de dados
            contatoPessoaRepository.delete(contOptional.get());
            return new ResponseEntity<>("Contato removido com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contato não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/removePessoa/{pessoaId}")
    @ResponseBody
    public ResponseEntity<String> removePessoa(@PathVariable Long pessoaId) {
        // Lógica para exclusão com base no memberId e workId recebidos
        Optional<Pessoa> pesOptional = pessoaRepository.findById(pessoaId);

        if (pesOptional.isPresent()) {
            // Se o membro existe, remova-o do banco de dados
            pessoaRepository.delete(pesOptional.get());
            return new ResponseEntity<>("Pessoa removido com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pessoa não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
