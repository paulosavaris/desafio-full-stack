package br.edu.unoesc.desafiofullstack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.desafiofullstack.Entidades.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String FormLoginEmail, String FormLoginPassword);

    
}
