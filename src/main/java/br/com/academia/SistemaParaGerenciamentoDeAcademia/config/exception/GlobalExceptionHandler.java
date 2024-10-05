package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.exception;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErroRespostaDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.ErroBancoDadosEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErroRespostaDto> handleCpfException(NegocioException e) {
        ErroRespostaDto erroRespostaDto = ErroRespostaDto.builder()
                .mensagem(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroRespostaDto);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErroRespostaDto> handleDataAccessException(DataAccessException e) {
        LOGGER.error("DataAccessException: {}", e.getMessage(), e);
        String erroMensagem = e.getMostSpecificCause().getMessage();
        ErroBancoDadosEnum erroBancoDadosEnum = ErroBancoDadosEnum.mensagemDoBanco(erroMensagem);

        if (erroBancoDadosEnum == ErroBancoDadosEnum.OUTRO_ERRO) {
            ErroRespostaDto erro = new ErroRespostaDto(erroBancoDadosEnum.getMensagemCustom());
            return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            ErroRespostaDto erro = new ErroRespostaDto(erroBancoDadosEnum.getMensagemCustom());
            return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
        }
    }
}