package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.CpfException;

public class ValidarCpfUtils {

    /**
     * Valida o CPF fornecido.
     * Verifica se todos os dígitos são iguais.
     * Calcula os dígitos verificadores
     * Verifica se os dígitos verificadores estão corretos
     * Lança uma exceção se o CPF for inválido.
     *
     * @param cpfSemFormatacao CPF a ser validado.
     */
    public static void validarCpf(String cpfSemFormatacao) {

        String cpf = cpfSemFormatacao.replaceAll("\\D", "");

        if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }

        if (cpf.chars().distinct().count() == 1) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }

        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int primeiroDigitoVerificador = 11 - (soma % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * pesos[i];
        }
        int segundoDigitoVerificador = 11 - (soma % 11);
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }

        if (cpf.charAt(9) - '0' != primeiroDigitoVerificador || cpf.charAt(10) - '0' != segundoDigitoVerificador) {
            throw new CpfException(MensagemExcecaoEnum.CPF_INVALIDO.getMensagem());
        }
    }

}
