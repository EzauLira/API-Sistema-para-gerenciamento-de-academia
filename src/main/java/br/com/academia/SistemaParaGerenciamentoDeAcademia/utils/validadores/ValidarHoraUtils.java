package br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidarHoraUtils {

    public static boolean validarHora(String hora) {
        try {
            if (hora.length() < 5){
                System.out.println(MensagemErroEnum.HORA_INVALIDA.getMensagem());
                return false;
            }
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(hora, formatoHora);
            return true;
        } catch (DateTimeParseException e) {
            System.out.println(MensagemExcecaoEnum.HORA_INVALIDA.getMensagem());
            return false;
        }
    }
}
