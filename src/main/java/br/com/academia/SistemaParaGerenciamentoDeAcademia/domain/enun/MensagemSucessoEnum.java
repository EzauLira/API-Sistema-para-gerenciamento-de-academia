package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun;

public enum MensagemSucessoEnum {

    CADASTRO_EFETUADO("Cadastro efetuado com sucesso!"),
    TREINO_AGENDADO("Treino agendado com sucesso!"),
    TREINO_ATUALIZADO("Treino atualizado com sucesso!"),
    TREINO_EXCLUIDO("Treino excluido com sucesso!"),
    LOGIN_EFETUADO("Login efetuado com sucesso!");

    private String mensagem;

    MensagemSucessoEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
