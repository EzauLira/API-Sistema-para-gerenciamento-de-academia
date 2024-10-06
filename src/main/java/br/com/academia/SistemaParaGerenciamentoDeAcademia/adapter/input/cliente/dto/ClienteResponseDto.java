package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    private String nome;
    private int idade;
    private String cpf;
    private int genero;
    private String telefone;
    private String email;
    private int idPlano;
    private String senha;
    private String planoNome;
}
