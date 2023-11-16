package br.edu.unoesc.desafiofullstack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.desafiofullstack.Repositories.ContatoPessoaRepository;
import br.edu.unoesc.desafiofullstack.Repositories.EnderecoPessoaRepository;
@Service
public class ContatoService {
    
    private final ContatoPessoaRepository contatoPessoaRepository;

    @Autowired
    public ContatoService(ContatoPessoaRepository contatoPessoaRepository) {
        this.contatoPessoaRepository = contatoPessoaRepository;
    }

    // Método para excluir um endereço com base no ID
    public void delete(Long enderecoId) {
        contatoPessoaRepository.deleteById(enderecoId);
    }

}
