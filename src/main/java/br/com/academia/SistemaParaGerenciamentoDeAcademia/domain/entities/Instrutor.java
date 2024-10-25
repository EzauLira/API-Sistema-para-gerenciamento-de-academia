package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {
    private String nome;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private String senha;

}
