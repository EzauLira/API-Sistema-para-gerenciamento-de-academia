package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ILoginController {

    ResponseEntity<RespostaPadraoDto> login(@RequestBody LoginRequestDto loginRequestDto);
}
