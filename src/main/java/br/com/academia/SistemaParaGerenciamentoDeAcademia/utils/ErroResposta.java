package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErroAutenticacaoRespostaDTO;

public class ErroResposta {

    public static ErroAutenticacaoRespostaDTO criarRespostaErro(String message, String path, Integer httpStatus) {
        return new ErroAutenticacaoRespostaDTO(message, path, httpStatus);
    }
}
