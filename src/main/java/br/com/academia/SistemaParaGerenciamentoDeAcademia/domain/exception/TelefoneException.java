package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception;

/**
 * Exceção lançada quando um telefone inválido é encontrado ou quando ocorre um erro relacionado ao telefone.
 */
public class TelefoneException extends RuntimeException {

    /**
     * Construtor para criar uma nova instância {@link TelefoneException}.
     *
     * @param mensagem A mensagem detalhando o erro relacionado ao telefone.
     */
    public TelefoneException(String mensagem) {
        super(mensagem);
    }
}
