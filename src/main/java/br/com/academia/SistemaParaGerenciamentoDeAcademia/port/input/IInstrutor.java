package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;

import java.util.List;

public interface IInstrutor {

    void efetuarLoginInstrutor(InstrutorRequestDto instrutorRequestDto);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

}
