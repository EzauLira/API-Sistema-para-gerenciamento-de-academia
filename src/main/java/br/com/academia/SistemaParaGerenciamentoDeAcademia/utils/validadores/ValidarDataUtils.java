package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Classe utilitária para validação de datas de agendamento.
 */
public class ValidarDataUtils {

    /**
     * Valida se a data fornecida iguala a data atual formatada.
     * Exibe uma mensagem de erro se a data for inválida.
     *
     * @param data Data a ser validada no formato "dd/MM/yyyy".
     * @return {@code true} se a data for inválida, {@code false} caso contrário.
     */
    public static boolean validarDataAgendamento(String data) {
        try {
            DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataVinda = LocalDate.parse(data, dataFormatada);
            LocalDate dataLimite = dataAtual.plusYears(1);

            if (dataVinda.isBefore(dataAtual)) {
                System.out.println(MensagemErroEnum.DATA_INVALIDA.getMensagem());
                return true;
            } else if (dataVinda.isAfter(dataLimite)) {
                System.out.println(MensagemErroEnum.DATA_INVALIDA_MAIOR.getMensagem());
                return true;
            } else {
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println(MensagemExcecaoEnum.DATA_INVALIDA.getMensagem());
        }
        return true;
    }

}