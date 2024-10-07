package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrador {

    private String usuario;
    private String senha;
}