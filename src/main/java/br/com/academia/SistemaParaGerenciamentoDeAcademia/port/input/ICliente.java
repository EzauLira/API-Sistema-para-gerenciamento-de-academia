package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.AgendamentoRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteResponseDto;

import java.util.List;

public interface ICliente {

    void cadastrarNovoCliente(ClienteRequestDto clienteRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    void efetuarLogin(ClienteRequestDto clienteRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    void agendarTreino(AgendamentoRequestDto agendamentoRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    void atualizarAgendamentoDeTreino(AgendamentoRequestDto agendamentoRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    void excluirAgendamentoAtivo(AgendamentoRequestDto agendamentoRequestDto);

    //--------------------------------------------------------------------------------------------------------------------//

    List<ClienteResponseDto> buscarClientePorNome(String primeiroNome);
}
