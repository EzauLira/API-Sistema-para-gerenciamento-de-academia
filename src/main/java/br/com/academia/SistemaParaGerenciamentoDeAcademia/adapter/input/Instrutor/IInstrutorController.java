package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IInstrutorController {

    //------------------------------------------------------------------------------------------------------------------------------------//

//    @Operation(summary = "Login do instrutor", description = "Loga um instrutor.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Login efetuado com sucesso"),
//            @ApiResponse(code = 400, message = "Dados de login inválidos"),
//            @ApiResponse(code = 500, message = "Erro interno do servidor")
//    })
//    ResponseEntity<RespostaPadraoDto> efetuarLoginInstrutor(LoginRequestDto loginRequestDto);

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
    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(ClienteRequestDto clienteRequestDto);

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "Busca histórico de um cliente", description = "Busca histórico de um cliente específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Histórico"),
            @ApiResponse(code = 400, message = "Dados para busca inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(ClienteRequestDto clienteRequestDto);
}
