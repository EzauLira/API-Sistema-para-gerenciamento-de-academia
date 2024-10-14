package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun;

/**
 * Enumeração para representar mensagens de exceção relacionadas a entradas inválidas
 * e outras condições de erro específicas no sistema. Cada tipo de exceção tem uma mensagem associada.
 */
public enum MensagemExcecaoEnum {

    SENHA_INVALIDA("Senha inválida."),
    SENHA_INVALIDA_LETRAMAIUSCULA("A senha deve conter pelo menos uma letra maiúscula."),
    SENHA_INVALIDA_CARACTER_ESPECIAL("A senha deve conter pelo menos um caractere especial."),
    SENHA_INVALIDA_CONTER_NUMERO("A senha deve conter pelo menos um número."),
    TELEFONE_INVALIDO("Telefone inválido. O telefone deve conter exatamente 11 dígitos numéricos, o DDD deve estar entre 01 e 99, o número de celular deve começar com 9 e não pode ter todos os dígitos iguais."),
    EMAIL_INVALIDO("É necessário que contenho um email valido."),
    HORA_INVALIDA("Hora inválida. Por favor, use o formato HH:mm."),
    DATA_INVALIDA("Data inválida. É necessária que seja no formato 01/01/2024"),
    ERRO_AUTENTICAR("Não foi possível autenticar."),
    CPF_INVALIDO("CPF inválido. O CPF deve conter exatamente 11 dígitos numéricos e não pode conter todos os dígitos iguais.");

    private final String mensagem;

    /**
     * Construtor para criar uma instância {@link MensagemExcecaoEnum}.
     *
     * @param mensagem A mensagem associada à exceção.
     */
    MensagemExcecaoEnum(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Obtém a mensagem associada à exceção.
     *
     * @return A mensagem da exceção.
     */
    public String getMensagem(){
        return mensagem;
    }

}
