package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.SenhaException;

public class ValidarSenhaUtils {

    /**
     * Valida a senha fornecida.
     * Lança uma exceção se a senha não atender aos critérios especificados.
     *
     * @param senha A senha a ser validada.
     */
    public static void validarSenha(String senha) {

        if (senha == null || senha.length() < 5) {
            throw new SenhaException(MensagemExcecaoEnum.SENHA_INVALIDA.getMensagem());
        }

        if (!senha.matches(".*[A-Z].*")) {
            throw new SenhaException(MensagemExcecaoEnum.SENHA_INVALIDA_LETRAMAIUSCULA.getMensagem());
        }

        if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new SenhaException(MensagemExcecaoEnum.SENHA_INVALIDA_CARACTER_ESPECIAL.getMensagem());
        }

        if (!senha.matches(".*[0-9].*")) {
            throw new SenhaException(MensagemExcecaoEnum.SENHA_INVALIDA_CONTER_NUMERO.getMensagem());
        }
    }
}

