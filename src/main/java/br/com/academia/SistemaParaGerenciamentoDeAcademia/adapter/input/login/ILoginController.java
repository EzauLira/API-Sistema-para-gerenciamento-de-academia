package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface ILoginController {

    @Operation(summary = "Login", description = "Loga um novo usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login efetuado com sucesso"),
            @ApiResponse(code = 400, message = "Dados do login inválidos"),
            @ApiResponse(code = 500, message = "Erro interno do servidor")
    })
    ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto);
}
