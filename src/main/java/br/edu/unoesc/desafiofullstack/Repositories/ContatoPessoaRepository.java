package br.edu.unoesc.desafiofullstack.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.desafiofullstack.Entidades.ContatoPessoa;
import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;

public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, Long>{

    Optional<Pessoa> findByIdpessoa(Long idpessoa);
    
}
