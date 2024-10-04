package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

public interface IClienteRepository {

    void cadastrarNovoCliente(Cliente cliente);
    boolean verificarSeClienteExiste(String cpf, String nome, String telefone, String email);

}
