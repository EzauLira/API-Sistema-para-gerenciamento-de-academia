package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ILogin;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.ILoginRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.ValidarCpfUtils;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.ValidarSenhaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginCommand implements ILogin {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);

    @Autowired
    ILoginRepository iLoginRepository;

    @Override
    public void login(LoginRequestDto loginRequestDto) {
        LOGGER.info("Início do método efetuarLogin na command.");


        LOGGER.info("Validando as informações para login.");
        ValidarCpfUtils.validarCpf(loginRequestDto.getCpf());
        ValidarSenhaUtils.validarSenha(loginRequestDto.getSenha());

        iLoginRepository.login(loginRequestDto);
    }
}
