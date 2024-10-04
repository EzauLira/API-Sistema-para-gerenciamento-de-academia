package br.com.academia.SistemaParaGerenciamentoDeAcademia.config.exception;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.ErroResposta;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.CpfException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErroResposta> handleCpfException(NegocioException ex) {
        ErroResposta erroResposta = ErroResposta.builder()
                .mensagem(ex.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResposta);
    }
}