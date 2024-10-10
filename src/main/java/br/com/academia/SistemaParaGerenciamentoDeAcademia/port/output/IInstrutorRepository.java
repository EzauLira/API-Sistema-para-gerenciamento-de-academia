package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;

import java.util.List;

public interface IInstrutorRepository {

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

}
