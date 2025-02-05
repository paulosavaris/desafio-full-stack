package br.edu.unoesc.desafiofullstack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.desafiofullstack.Entidades.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    boolean existsByCPF(String CPF);
}
