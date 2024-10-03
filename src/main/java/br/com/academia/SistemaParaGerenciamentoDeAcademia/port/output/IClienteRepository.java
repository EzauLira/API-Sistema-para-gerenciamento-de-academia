package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

public interface IClienteRepository {

    void cadastrarNovoCliente(Cliente cliente);
}
