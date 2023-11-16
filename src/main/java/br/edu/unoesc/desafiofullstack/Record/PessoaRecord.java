package br.edu.unoesc.desafiofullstack.Record;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public record PessoaRecord(Long id, String CadastroNome, String CadastroCPF,
        @DateTimeFormat(pattern = "yyyy-MM-dd") Date CadastroDatNasc, String CadastroSexo) {

}
