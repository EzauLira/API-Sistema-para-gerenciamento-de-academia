package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.AgendamentoRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public interface IClienteController {

    @Operation(summary = "Cadastro Cliente", description = "Cadastra um novo cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastro efetuado com sucesso"),
            @ApiResponse(code = 400, message = "Dados do cadastro inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> cadastrarNovoCliente(ClienteRequestDto clienteRequestDto);


    //--------------------------------------------------------------------------------------------------------------------//


    @Operation(summary = "Agenda um treino", description = "Agenda um novo treino.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Treino agendado com sucesso"),
            @ApiResponse(code = 400, message = "Dados do agendamento inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> agendarTreino(AgendamentoRequestDto agendamentoRequestDto);


    //--------------------------------------------------------------------------------------------------------------------//


    @Operation(summary = "Atualizar treino", description = "Atualiza um treino ativo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Treino atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Dados do novo agendamento inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> atualizarAgendamentoDeTreino(AgendamentoRequestDto agendamentoRequestDto);


    //--------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "Exluir agendamento", description = "Excluí um treino ativo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Treino excluido com sucesso"),
            @ApiResponse(code = 400, message = "Dados do agendamento inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> excluirAgendamentoAtivo(AgendamentoRequestDto agendamentoRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "Buscar dados pessoais", description = "Busca dados pessoais do cliente pelo primeiro nome.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados do cliente."),
            @ApiResponse(code = 400, message = "Dados do cliente inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<ClienteResponseDto> buscarPorNome(String nome);


}
