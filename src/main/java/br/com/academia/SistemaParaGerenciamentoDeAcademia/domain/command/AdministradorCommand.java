package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.AdministradorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Administrador;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.IAdministrador;
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
    IAdministradorRepository iadministradorRepository;

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

        LOGGER.info("Construindo o Instrutor - command.");
        Instrutor instrutor = Instrutor.builder()
                .nome(instrutorRequestDto.getNome())
                .cpf(instrutorRequestDto.getCpf())
                .genero(instrutorRequestDto.getGenero())
                .telefone(instrutorRequestDto.getTelefone())
                .email(instrutorRequestDto.getEmail())
                .senha(instrutorRequestDto.getSenha())
                .build();

        LOGGER.info("Salvando o instrutor - command.");
        iadministradorRepository.cadastrarNovoInstrutor(instrutor);
    }

    //--------------------------------------------------------------------------------------------------------------------//


    @Override
    public void efetuarLogin(AdministradorRequestDto administradorRequestDto){
        LOGGER.info("Início do método efetuarLogin da command para um ADM.");

        LOGGER.info("Construindo o ADM para login - command.");
        Administrador administrador = Administrador.builder()
                .usuario(administradorRequestDto.getUsuario())
                .senha(administradorRequestDto.getSenha())
                .build();

        LOGGER.info("Salvando os dados do ADM - command.");
       iadministradorRepository.efetuarLogin(administrador);
    }

    @Override
    public List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia(){
        LOGGER.info("Início do método listarEstatisticasDaAcademia da command para um ADM");
        return iadministradorRepository.listarEstatisticasDaAcademia();
    }

    //--------------------------------------------------------------------------------------------------------------------//
}
