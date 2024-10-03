package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.IdadeException;

/**
 * Classe utilitária para validação de idade.
 */
public class ValidarIDadeUtils {

    /**
     * Valida a idade fornecida.
     * Lança uma exceção se a idade for inválida.
     *
     * @param idade Idade a ser validada.
     */
    public static void validarIdade(int idade){

        if (idade < 15 || idade > 150 ){
            throw new IdadeException(MensagemErroEnum.IDADE_INVALIDA.getMensagem());
        }
    }
}
