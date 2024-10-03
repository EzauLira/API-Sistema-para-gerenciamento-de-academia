package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

/**
 * Exceção lançada quando a idade fornecida é inválida ou quando ocorre um erro relacionado à idade.
 */
public class IdadeException extends RuntimeException {

    /**
     * Construtor para criar uma nova instância {@link IdadeException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado à idade.
     */
    public IdadeException(String mensagem){
        super(mensagem);
    }
}
