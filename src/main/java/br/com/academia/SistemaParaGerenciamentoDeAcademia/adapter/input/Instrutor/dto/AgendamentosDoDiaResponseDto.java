package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgendamentosDoDiaResponseDto {

    private String id;
    private String clienteNome;
    private String treinoNome;
    private String data;
    private String hora;
}
