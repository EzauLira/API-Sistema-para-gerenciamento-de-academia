package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroResposta {

    private String mensagem;
}
