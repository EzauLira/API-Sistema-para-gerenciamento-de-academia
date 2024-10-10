package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ILoginController {

    ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto);
}
