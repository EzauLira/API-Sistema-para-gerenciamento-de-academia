package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErroAutenticacaoRespostaDTO {

    private String mensagem;
    private String path;
    private Integer code;
}
