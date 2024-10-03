package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.EmailException;

/**
 * Classe utilitária para validação de e-mails.
 */
public class ValidarEmailUtils {

    /**
     * Valida o e-mail fornecido.
     * Lança uma exceção se o e-mail for inválido.
     *
     * @param email E-mail a ser validado.
     */
    public static void validarEmail(String email){

        if (email.trim().isEmpty() || !email.contains("@") ||
                (!email.contains(".com") && !email.contains(".br") && !email.contains(".org"))) {
            throw new EmailException(MensagemErroEnum.EMAIL_INVALIDO.getMensagem());
        }

    }
}
