package br.edu.unoesc.desafiofullstack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstack.Repositories.EnderecoPessoaRepository;
@Service
public class EnderecoService {

    private final EnderecoPessoaRepository enderecoPessoaRepository;

    @Autowired
    public EnderecoService(EnderecoPessoaRepository enderecoRepository) {
        this.enderecoPessoaRepository = enderecoRepository;
    }

    // Método para excluir um endereço com base no ID
    public void delete(Long enderecoId) {
        enderecoPessoaRepository.deleteById(enderecoId);
    }

}
