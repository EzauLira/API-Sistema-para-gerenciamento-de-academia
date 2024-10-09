package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;

public interface ILoginRepository {

    void login(LoginRequestDto loginRequestDto);
    Cliente existePessoa(String cpf);
}
