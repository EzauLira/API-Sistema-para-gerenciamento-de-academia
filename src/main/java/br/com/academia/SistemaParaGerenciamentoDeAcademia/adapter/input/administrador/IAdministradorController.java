package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IAdministradorController{

    //--------------------------------------------------------------------------------------------------------------------//

    @Operation(summary = "Cadastrar instrutor", description = "Cadastra um novo instrutor.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastro efetuado com sucesso"),
            @ApiResponse(code = 400, message = "Dados do cadastro inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> cadastrarNovoInstrutor(InstrutorRequestDto instrutorRequestDto);


    //--------------------------------------------------------------------------------------------------------------------//



    @Operation(summary = "Buscar estatísticas", description = "Busca estatísticas da academia.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Dados da academia."),
            @ApiResponse(code = 400, message = "Dados da academia inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia();


    //--------------------------------------------------------------------------------------------------------------------//

}
