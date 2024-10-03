package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;

public interface ICliente {

    void cadastrarNovoCliente(ClienteRequestDto clienteRequestDto);
}
