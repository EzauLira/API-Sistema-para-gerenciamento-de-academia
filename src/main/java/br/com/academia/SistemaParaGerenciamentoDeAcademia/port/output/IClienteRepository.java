package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Agendamento;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

import java.util.List;

public interface IClienteRepository {

    //--------------------------------------------------------------------------------------------------------------------//

    void cadastrarNovoCliente(Cliente cliente);

    //--------------------------------------------------------------------------------------------------------------------//

    void efetuarLogin(Cliente cliente);

    //--------------------------------------------------------------------------------------------------------------------//

    void agendarTreino(Agendamento agendamento);

    //--------------------------------------------------------------------------------------------------------------------//

    void atualizarAgendamentoDeTreino(Agendamento agendamento);

    //--------------------------------------------------------------------------------------------------------------------//

    void excluirAgendamentoAtivo(Agendamento agendamento);

    //--------------------------------------------------------------------------------------------------------------------//

    List<ClienteResponseDto> buscarDadosPessoaisPeloPrimeiroNome(String primeiroNome);

    //--------------------------------------------------------------------------------------------------------------------//

    //boolean verificarSeClienteExiste(String cpf, String nome, String telefone, String email);

}
