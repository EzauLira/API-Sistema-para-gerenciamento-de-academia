package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;

import java.util.List;

public interface IInstrutorRepository {

    void efetuarLoginInstrutor(Instrutor instrutor);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

    List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(String nome);

    //------------------------------------------------------------------------------------------------------------------------------------//

}
