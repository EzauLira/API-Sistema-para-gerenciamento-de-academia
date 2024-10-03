package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

/**
 * Exceção lançada quando um e-mail inválido é encontrado ou quando ocorre um erro relacionado ao e-mail.
 */
public class EmailException extends RuntimeException{

    /**
     * Construtor para criar uma nova instância {@link EmailException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado ao e-mail.
     */
    public EmailException(String mensagem){
        super(mensagem);
    }
}
