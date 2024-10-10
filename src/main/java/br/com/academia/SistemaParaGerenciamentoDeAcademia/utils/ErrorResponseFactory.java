package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErrorAutenticacaoResponseDTO;

public class ErrorResponseFactory {

    public static ErrorAutenticacaoResponseDTO createResponseError(String message, String path, Integer httpStatus) {
        return new ErrorAutenticacaoResponseDTO(message, path, httpStatus);
    }
}
