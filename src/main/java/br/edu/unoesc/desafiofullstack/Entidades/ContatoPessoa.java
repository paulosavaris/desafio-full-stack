package br.edu.unoesc.desafiofullstack.Entidades;

import br.edu.unoesc.desafiofullstack.Record.ContatoPessoaRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class ContatoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontato")
    private Long id;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "idpessoa")
    private Long idpessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }

    public ContatoPessoa() {
    };

    public ContatoPessoa(ContatoPessoaRecord contatoDados) {
        this.telefone = contatoDados.CadastroTelefone();
        this.email = contatoDados.CadastroEmail();
        this.idpessoa = contatoDados.idpessoa();
    }

}
