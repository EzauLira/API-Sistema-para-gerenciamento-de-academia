package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

/**
 * Exceção lançada quando um CPF inválido é encontrado ou quando ocorre um erro relacionado ao CPF.
 */
public class CpfException extends RuntimeException{

    /**
     * Construtor para criar uma nova instância {@link CpfException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado ao CPF.
     */
    public CpfException(String mensagem){
        super(mensagem);
    }

}
