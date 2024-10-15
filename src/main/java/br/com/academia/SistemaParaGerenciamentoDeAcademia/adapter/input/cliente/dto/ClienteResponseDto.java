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
    private String cpf;
    private String telefone;
    private String email;
    //private String senha;
    private String planoNome;
}
