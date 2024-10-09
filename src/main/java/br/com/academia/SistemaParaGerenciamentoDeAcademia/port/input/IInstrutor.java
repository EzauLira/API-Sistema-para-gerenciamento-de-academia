package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;

import java.util.List;

public interface IInstrutor {

//    void efetuarLoginInstrutor(LoginRequestDto loginRequestDto);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

}
