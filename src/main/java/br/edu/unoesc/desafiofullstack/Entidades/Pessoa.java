package br.edu.unoesc.desafiofullstack.Entidades;

import java.util.Date;

import br.edu.unoesc.desafiofullstack.Record.PessoaRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String CPF;

    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Column(name = "sexo")
    private String sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public Pessoa(PessoaRecord dados) {
        this.nome = dados.CadastroNome();
        this.CPF = dados.CadastroCPF();
        this.dataNascimento = dados.CadastroDatNasc();
        this.sexo = dados.CadastroSexo();
    }

}
