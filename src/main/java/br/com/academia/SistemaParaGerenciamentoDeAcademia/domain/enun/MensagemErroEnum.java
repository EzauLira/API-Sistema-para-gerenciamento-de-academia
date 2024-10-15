package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun;

/**
 * Enumeração para representar as mensagens de erro relacionadas a entradas inválidas
 * e outras condições de erro no sistema. Cada tipo de erro tem uma mensagem associada.
 */
public enum MensagemErroEnum {

    IDADE_INVALIDA("A idade precisa ser maior que 15 ano e menor que 150."),
    EMAIL_INVALIDO("Necessário que contenho um email valido."),
    HORA_INVALIDA("A hora precisa ser futuras."),
    DATA_INVALIDA("Data inválida. A data de agendamento não pode ser antes da data atual."),
    DATA_INVALIDA_MAIOR("A data de agendamento não pode ser superior a um ano a partir da data atual."),
    NOME_INVALIDO("Nome inválido.");

    private final String mensagem;

    /**
     * Construtor para criar uma nova instância {@link MensagemErroEnum}.
     *
     * @param mensagem A mensagem associada ao erro.
     */
    MensagemErroEnum(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Obtém a mensagem associada ao erro.
     *
     * @return A mensagem do erro.
     */
    public String getMensagem(){
        return mensagem;
    }
}
