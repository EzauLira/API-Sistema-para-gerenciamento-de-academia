package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar os dados de um agendamento de treino na academia.
 * Este objeto é utilizado para transferir as informações necessárias para agendar um treino.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    private int idAgendamento;
    private int idCliente;
    private int idTreino;
    private String treinoNome;
    private int novoTreino;
    private String data;
    private String hora;

}
