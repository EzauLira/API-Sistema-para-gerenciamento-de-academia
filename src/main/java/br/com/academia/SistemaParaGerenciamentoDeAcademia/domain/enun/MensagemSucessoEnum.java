package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun;

public enum MensagemSucessoEnum {

    CADASTRO_EFETUADO("Cadastro efetuado com sucesso!");

    private String mensagem;

    MensagemSucessoEnum(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }
}
