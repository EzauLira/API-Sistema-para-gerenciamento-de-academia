package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

public class NegocioBancoException extends RuntimeException {

    public NegocioBancoException(String mensagem){
        super(mensagem);
    }
}
