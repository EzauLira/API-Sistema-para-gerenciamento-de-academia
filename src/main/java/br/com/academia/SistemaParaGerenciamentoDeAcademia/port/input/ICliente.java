package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;

public interface ICliente {

    String cadastrarNovoCliente(ClienteRequestDto clienteRequestDto);
}
