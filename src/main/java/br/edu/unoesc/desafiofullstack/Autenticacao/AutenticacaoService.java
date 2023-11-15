package br.edu.unoesc.desafiofullstack.Autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class AutenticacaoService {
    
    public boolean isUsuarioLogado(HttpSession session){
        return session.getAttribute("usuarioLogado") != null;
    }

}
