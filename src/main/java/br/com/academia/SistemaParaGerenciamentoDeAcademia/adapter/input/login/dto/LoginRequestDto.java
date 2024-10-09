package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

    private String usuario;
    private String cpf;
    private String senha;
}
