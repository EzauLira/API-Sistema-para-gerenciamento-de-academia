package br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;

public interface ILogin {


    String login(LoginRequestDto loginRequestDto);
}
