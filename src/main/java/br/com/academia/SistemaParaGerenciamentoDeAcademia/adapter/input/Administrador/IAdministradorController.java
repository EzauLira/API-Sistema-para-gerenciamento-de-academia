package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.AdministradorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.EstatisticasResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IAdministradorController{

    //--------------------------------------------------------------------------------------------------------------------//


    @Operation(summary = "Login do ADM", description = "Loga um ADM.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login efetuado com sucesso"),
            @ApiResponse(code = 400, message = "Dados de login inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<RespostaPadraoDto> efetuarLogin(AdministradorRequestDto administradorRequestDto);


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
    List<EstatisticasResponseDto> listarEstatisticasDaAcademia();


    //--------------------------------------------------------------------------------------------------------------------//

}
