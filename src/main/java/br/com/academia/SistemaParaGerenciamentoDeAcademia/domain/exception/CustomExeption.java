package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

public class CustomExeption extends RuntimeException {

    public CustomExeption(String mensagem){
        super(mensagem);
    }
}
