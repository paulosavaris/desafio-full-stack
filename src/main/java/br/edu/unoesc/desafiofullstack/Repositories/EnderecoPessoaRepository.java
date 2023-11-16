package br.edu.unoesc.desafiofullstack.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.desafiofullstack.Entidades.EnderecoPessoa;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, Long>{
    
    List<EnderecoPessoa> findByIdPessoa(Long idPessoa);
}
