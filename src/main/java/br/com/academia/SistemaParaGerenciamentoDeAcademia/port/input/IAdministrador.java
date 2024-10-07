package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.AdministradorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.EstatisticasResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;

import java.util.List;

public interface IAdministrador {
    //--------------------------------------------------------------------------------------------------------------------//

    void cadastrarNovoInstrutor(InstrutorRequestDto instrutorRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    void efetuarLogin(AdministradorRequestDto administradorRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    List<EstatisticasResponseDto> listarEstatisticasDaAcademia();

    //--------------------------------------------------------------------------------------------------------------------//

}
