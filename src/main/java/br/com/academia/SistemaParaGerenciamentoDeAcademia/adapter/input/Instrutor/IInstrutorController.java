package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface IInstrutorController {

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "lista agendamento do dia", description = "Lista todos agendamentos ativos do dia.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de agendamentos"),
            @ApiResponse(code = 400, message = "Dados do agendamento inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "lista treinos de um cliente", description = "Lista todos treinos de um cliente específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de treinos"),
            @ApiResponse(code = 400, message = "Dados inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "Busca histórico de um cliente", description = "Busca histórico de um cliente específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Histórico"),
            @ApiResponse(code = 400, message = "Dados para busca inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(String nome);
}
