package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun;


/**
 * Enumeração para representar os diferentes tipos de erros que podem ocorrer
 * ao interagir com o banco de dados. Cada tipo de erro tem uma mensagem padrão
 * e uma mensagem customizada associada a ele.
 */
public enum ErroBancoDadosEnum {

    MESMO_TREINO("O mesmo treino já está agendado", "O mesmo treino já está agendado ou você já fez este treino nesta data."),
    ERRO_DATA_E_HORA_PASSADAS("A data e hora do agendamento devem ser futuras.", "A data e/ou hora do agendamento devem ser futuras."),
    FORA_DAS_TRES_OPCOES_DE_TREINO("Treino inválido. Deve ser 1, 2 ou 3.", "Treino escolhido inválido: Deve ser umas das opções validas: (1, 2, 3)."),
    HORA_INVALIDA("valor do campo date/time está fora do intervalo:", "Horário inválido. Por favor, informe um horário válido."),
    JA_EXISTE_TREINO("Já existe um treino agendado", "Já existe um treino agendado para este cliente nesta data e hora. Deve haver pelo menos 30 minutos de diferença entre os treinos."),
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado", "Cliente não encontrado. Por favor reveja o nome digitado, Caso não lembre do nome cliente vá em BUSCAR DADOS."),
    ERRO_CLIENTE_NAO_ENCONTRADO("Cliente não encontrado.", "Cliente não encontrado. Por favor reveja o nome digitado."),
    NOME_JA_CADASTRADO("Erro: Nome já cadastrado.", "Nome já está cadastrado."),
    CPF_JA_CADASTRADO("Erro: CPF já cadastrado.", "CPF já está cadastrado."),
    TELEFONE_JA_CADASTRADO("Erro: Telefone já cadastrado.", "Telefone já está cadastrado."),
    EMAIL_JA_CADASTRADO("Erro: Email já cadastrado.", "Email já está cadastrado."),
    SENHA_SEM_CARACTERE_ESPECIAL("A senha deve conter pelo menos um caractere especial (@ ou .)", "A senha deve conter pelo menos um caractere especial (@ ou .)"),
    SENHA_SEM_LETRA_MAIUSCULA("A senha deve conter pelo menos uma letra maiúscula", "A senha deve conter pelo menos uma letra maiúscula"),
    SENHA_SEM_CINCO_CARACTERES("A senha deve ter pelo menos 5 caracteres", "A senha deve ter pelo menos 5 caracteres"),
    SENHA_SEM_NUMERO("A senha deve conter pelo menos um número", "A senha deve conter pelo menos um número"),
    OPCAO_INVALIDA_TREINO("inserção ou atualização em tabela", "Opção inválida de treino ou gênero. Por favor escolha um das três opções de existentes."),
    NOME_NAO_ENCONTRADO("Nome não encontrado", "Cliente não encontrado. Verifique se o nome está correto ou talvez essa pessoa não esteja cadastrada."),
    CPF_NAO_ENCONTRADO("CPF não cadastrado", "CPF não encontrado ou não cadastrado."),
    SENHA_INCORRETA("Senha incorreta", "Senha inválida."),
    NENHUM_TRIENO_ATIVO_ENCONTRADO("Nenhum treino ativo encontrado para o cliente.", "Nenhum treino ativo encontrado."),
    ERRO_NENHUM_TRIENO_ENCONTADO("Nenhum treino ativo encontrado para o cliente.", "Nenhum treino ativo encontrado."),
    ERRO_NENHUM_TRIENO_ATIVO_ENCONTRADO("Nenhum treino ativo encontrado para o cliente.", "Nenhum treino ativo encontrado para esse cliente."),
    NENHUM_TRIENO_INATIVO_ENCONTRADO("Nenhum treino inativo encontrado para o cliente.", "Nenhum treino inativo encontrado."),
    ERRO_NOVO_AGENDAMENTO("Agendamento não encontrado ou não pertence ao cliente.", "Agendamento não encontrado."),
    ERRO_DELETAR_AGENDAMENTO("Nenhum treino ativo encontrado para o agendamento fornecido.", "Nenhum treino ativo encontrado."),
    ERRO_LOGAR_ADMIN_USUARIO_VAZIO("O nome do usuário não pode ser vazio", "O nome o usuário não pode ser vazio"),
    ERRO_LOGAR_ADMIN_SENHA_VAZIO("A senha não pode ser vazia", "A senha não pode ser vazia"),
    ERRO_LOGAR_ADMIN_USUARIO_NAO_ENCONTRADO("Usuário não encontrado na base de dados", "Usuário não encontrado na base de dados"),
    ERRO_LOGAR_ADMIN_SENHA_INCORRETA("Senha incorreta", "Senha incorreta"),
    ERRO_AUTENTICAR("Não foi possível autenticar.", "Não foi possível autenticar."),
    ERRO_LISTAR_AGENDAMENTO_HOJE("Nenhum agendamento encontrado para a data atual.", "Nenhum agendamento encontrado para a data atual."),
    ERRO_NOME_VAZIO_NA_BUSCA_POR_PESSOA_ESPECIFICA("O nome não pode ser vazio. Por favor, forneça um nome válido.", "O nome não pode ser vazio. Por favor, forneça um nome válido."),
    OUTRO_ERRO("Outro erro", "Erro não catalogado. Favor, entre em contato com nosso suporte técnico.");

    private final String mensagem;
    private final String mensagemCustom;

    /**
     * Construtor para criar uma nova instância {@link ErroBancoDadosEnum}.
     *
     * @param mensagem A mensagem padrão associada ao erro.
     * @param mensagemCustom A mensagem customizada associada ao erro.
     */
    ErroBancoDadosEnum(String mensagem, String mensagemCustom) {
        this.mensagem = mensagem;
        this.mensagemCustom = mensagemCustom;
    }

    /**
     * Retorna o tipo de erro correspondente com base na mensagem fornecida.
     * Se a mensagem não corresponder a nenhum erro catalogado, retorna {@link #OUTRO_ERRO}.
     *
     * @param message A mensagem de erro recebida.
     * @return O tipo de erro correspondente.
     */
    public static ErroBancoDadosEnum mensagemDoBanco(String message) {
        for (ErroBancoDadosEnum mensagem : ErroBancoDadosEnum.values()) {
            if (message.contains(mensagem.mensagem)) {
                return mensagem;
            }
        }
        return OUTRO_ERRO;
    }

    /**
     * Obtém a mensagem customizada associada ao erro.
     *
     * @return A mensagem customizada do erro.
     */
    public String getMensagemCustom() {
        return mensagemCustom;
    }
}