package br.edu.unoesc.desafiofullstack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.desafiofullstack.Entidades.EnderecoPessoa;

public interface CadastroEndRepository extends JpaRepository<EnderecoPessoa, Long> {
    
}
