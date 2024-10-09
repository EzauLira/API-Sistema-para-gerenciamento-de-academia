package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.TokenResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemSucessoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ILogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/login")
public class LoginController implements ILoginController{


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    ILogin loginCommand;

    @Override
    @PostMapping("/logar")
    public ResponseEntity<RespostaPadraoDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LOGGER.info("Inicio do método para efetuar login - Controller");

        long startTime = System.currentTimeMillis();

        TokenResponseDto tokenResponseDto = new TokenResponseDto(loginCommand.login(loginRequestDto));

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.LOGIN_EFETUADO.getMensagem()).dados(tokenResponseDto)
                        .build());
    }
}
