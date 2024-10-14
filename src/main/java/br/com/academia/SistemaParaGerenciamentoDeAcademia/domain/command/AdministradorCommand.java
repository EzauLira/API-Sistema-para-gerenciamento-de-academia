package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.IAdministrador;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ISegurancaConfig;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IAdministradorRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorCommand implements IAdministrador {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministradorCommand.class);

    @Autowired
    IAdministradorRepository administradorRepository;
    @Autowired
    ISegurancaConfig segurancaConfig;

    //--------------------------------------------------------------------------------------------------------------------//


    @Override
    public void cadastrarNovoInstrutor(InstrutorRequestDto instrutorRequestDto) {
        LOGGER.info("Início do método cadastrarNovoInstrutor da command para cadastro de um instrutor.");


        LOGGER.info("Validando as informações do Instrutor - command.");
        ValidarNomeUtils.validarNome(instrutorRequestDto.getNome());
        ValidarCpfUtils.validarCpf(instrutorRequestDto.getCpf());
        ValidarTelefoneUtils.validarTelefone(instrutorRequestDto.getTelefone());
        ValidarEmailUtils.validarEmail(instrutorRequestDto.getEmail());
        ValidarSenhaUtils.validarSenha(instrutorRequestDto.getSenha());


        LOGGER.info("Criptografando senha do isntrutor - command");
        String senhaCripto = segurancaConfig.criptografarSenha(instrutorRequestDto.getSenha());

        LOGGER.info("Construindo o Instrutor - command.");
        Instrutor instrutor = Instrutor.builder()
                .nome(instrutorRequestDto.getNome())
                .cpf(instrutorRequestDto.getCpf())
                .genero(instrutorRequestDto.getGenero())
                .telefone(instrutorRequestDto.getTelefone())
                .email(instrutorRequestDto.getEmail())
                .senha(senhaCripto)
                .build();

        LOGGER.info("Salvando o instrutor - command.");
        administradorRepository.cadastrarNovoInstrutor(instrutor);
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia(){
        LOGGER.info("Início do método listarEstatisticasDaAcademia da command para um ADM");
        return administradorRepository.listarEstatisticasDaAcademia();
    }

    //--------------------------------------------------------------------------------------------------------------------//
}
