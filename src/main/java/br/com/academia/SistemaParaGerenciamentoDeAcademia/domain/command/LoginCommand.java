package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemExcecaoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ILogin;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ISegurancaConfig;
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
    ILoginRepository loginRepository;

    @Autowired
    ISegurancaConfig segurancaConfig;

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        LOGGER.info("Início do método efetuarLogin na command.");


        LOGGER.info("Validando as informações para login - command.");
        ValidarCpfUtils.validarCpf(loginRequestDto.getCpf());
        ValidarSenhaUtils.validarSenha(loginRequestDto.getSenha());

        LOGGER.info("Verificando se a pessoa existe na base de dados - command");
        Cliente cliente = loginRepository.existePessoa(loginRequestDto.getCpf());

        LOGGER.info("Autenticando o usuario");
        if (segurancaConfig.compararSenhaHash(loginRequestDto.getSenha(), cliente.getSenha())) {
            return segurancaConfig.gerarToken(cliente);
        }

        throw new NegocioException(MensagemExcecaoEnum.ERRO_AUTENTICAR.getMensagem());
    }
}
