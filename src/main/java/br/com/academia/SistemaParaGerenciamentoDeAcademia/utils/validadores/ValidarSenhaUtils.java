package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;
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
            throw new SenhaException("A senha deve conter pelo menos uma letra maiúscula.");
        }

        if (!senha.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new SenhaException("A senha deve conter pelo menos um caractere especial.");
        }

        if (!senha.matches(".*[0-9].*")) {
            throw new SenhaException("A senha deve conter pelo menos um número.");
        }
    }
}

