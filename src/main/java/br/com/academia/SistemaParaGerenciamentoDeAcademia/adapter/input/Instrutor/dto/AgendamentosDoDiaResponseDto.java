package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentosDoDiaResponseDto {

    private String id;
    private String clienteNome;
    private String treinoNome;
}
