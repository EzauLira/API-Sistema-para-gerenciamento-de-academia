package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticasAcademiaResponseDto {

    private String totalClientes;
    private String planoMensalVendido;
    private String planoAnualVendido;
    private String planoTrimestralVendido;

}
