package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.exception;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErroRespostaDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.ErroBancoDadosEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErroRespostaDto> handleNegocioException(NegocioException e) {
        LOGGER.error("NegocioException: {}", e.getMessage(), e);

        if (e instanceof NegocioException) {

            ErroRespostaDto erroRespostaDto = new ErroRespostaDto(e.getMessage());
            return new ResponseEntity<>(erroRespostaDto, HttpStatus.BAD_REQUEST);
        }

        String erroDoBanco = e.getMessage();
        ErroBancoDadosEnum erroBancoDadosEnum = ErroBancoDadosEnum.mensagemDoBanco(erroDoBanco);

        ErroRespostaDto erroResposta = new ErroRespostaDto(erroBancoDadosEnum.getMensagemCustom());
        if (erroBancoDadosEnum == ErroBancoDadosEnum.OUTRO_ERRO) {
            return new ResponseEntity<>(erroResposta, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(erroResposta, HttpStatus.BAD_REQUEST);
        }
    }
}