package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

import org.springframework.dao.DataAccessException;

public class DataTeste extends DataAccessException {

    public DataTeste(String mensagem){
        super(mensagem);
    }
}
