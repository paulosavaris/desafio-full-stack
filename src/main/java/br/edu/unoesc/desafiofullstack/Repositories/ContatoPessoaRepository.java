package br.edu.unoesc.desafiofullstack.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.desafiofullstack.Entidades.ContatoPessoa;

public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, Long>{
    
    List<ContatoPessoa> findByIdpessoa(Long idpessoa);

}
