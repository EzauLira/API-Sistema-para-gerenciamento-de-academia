package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Administrador;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;

import java.util.List;

public interface IAdministradorRepository {

    //--------------------------------------------------------------------------------------------------------------------//

    void cadastrarNovoInstrutor(Instrutor instrutor);

    //--------------------------------------------------------------------------------------------------------------------//

    void efetuarLogin(Administrador administrador);

    //--------------------------------------------------------------------------------------------------------------------//

    List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia();

    //--------------------------------------------------------------------------------------------------------------------//

}
