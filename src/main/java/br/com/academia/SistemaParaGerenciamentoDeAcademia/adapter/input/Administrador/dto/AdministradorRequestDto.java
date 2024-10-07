package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorRequestDto {

    private String usuario;
    private String senha;
}
