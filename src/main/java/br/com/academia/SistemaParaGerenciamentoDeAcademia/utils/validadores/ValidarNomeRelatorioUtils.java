package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;

/**
 * Classe utilitária para validação de nomes de relatórios.
 */
public class ValidarNomeRelatorioUtils {

    /**
     * Valida o nome fornecido para relatórios.
     * Exibe uma mensagem de erro se o nome for inválido.
     *
     * @param nome Nome a ser validado.
     * @return {@code true} se o nome for inválido, {@code false} caso contrário.
     */
    public static boolean validarNome(String nome) {

        if (nome.trim().isEmpty() || nome.length() < 10 || nome.matches(".*\\d.*")){
            System.out.println(MensagemErroEnum.NOME_INVALIDO.getMensagem());
            return true;
        } else {
            return false;
        }
    }
}
