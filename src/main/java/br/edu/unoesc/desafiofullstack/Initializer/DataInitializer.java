package br.edu.unoesc.desafiofullstack.Initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.unoesc.desafiofullstack.Entidades.Usuario;
import br.edu.unoesc.desafiofullstack.Repositories.UsuariosRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    //Injeta o repositorio de usuarios
    @Autowired
    private UsuariosRepository usuariosRepository;

    //Metodo chamado durante inicializacao
    @Override
    public void run(String... args) throws Exception {
        popularUsuarios();
    }

    //popular BD com alguns usuarios
    private void popularUsuarios() {
        if (usuariosRepository.count() == 0) {
            Usuario usuarioPaulo = new Usuario();
            usuarioPaulo.setNome("Paulo Savaris");
            usuarioPaulo.setEmail("paulo@gmail.com");
            usuarioPaulo.setSenha("paulo123");
            usuariosRepository.save(usuarioPaulo);

            Usuario usuarioUnoesc = new Usuario();
            usuarioUnoesc.setNome("Unoesc TI");
            usuarioUnoesc.setEmail("unoescTI@gmail.com");
            usuarioUnoesc.setSenha("unoesc123");
            usuariosRepository.save(usuarioUnoesc);

            Usuario usuarioEduarda = new Usuario();
            usuarioEduarda.setNome("Eduarda adm");
            usuarioEduarda.setEmail("adm_eduarda@gmail.com");
            usuarioEduarda.setSenha("eduarda123");
            usuariosRepository.save(usuarioEduarda);
        }
    }

}
