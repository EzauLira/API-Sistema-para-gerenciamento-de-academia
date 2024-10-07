package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrutorRequestDto {

    private String nome;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private String senha;
}
