package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;

public interface ILoginRepository {

    void login(LoginRequestDto loginRequestDto);
}
