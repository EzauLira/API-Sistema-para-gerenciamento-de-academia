package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.AgendamentoRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output.ClienteRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Agendamento;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ICliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ISegurancaConfig;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCommand implements ICliente {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteCommand.class);

    @Autowired
    IClienteRepository clienteRepository;
    @Autowired
    ISegurancaConfig segurancaConfig;

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public void cadastrarNovoCliente(ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método cadastrarNovoCliente da command para cadastro de um cliente.");


        LOGGER.info("Validando as informações do cliente.");
        ValidarNomeUtils.validarNome(clienteRequestDto.getNome());
        ValidarIDadeUtils.validarIdade(clienteRequestDto.getIdade());
        ValidarCpfUtils.validarCpf(clienteRequestDto.getCpf());
        ValidarTelefoneUtils.validarTelefone(clienteRequestDto.getTelefone());
        ValidarEmailUtils.validarEmail(clienteRequestDto.getEmail());
        ValidarSenhaUtils.validarSenha(clienteRequestDto.getSenha());

        LOGGER.info("Criptografando senha do isntrutor - command");
        String senhaCripto = segurancaConfig.criptografarSenha(clienteRequestDto.getSenha());

        LOGGER.info("Construindo o cliente.");
        Cliente cliente = Cliente.builder()
                .nome(clienteRequestDto.getNome())
                .idade(clienteRequestDto.getIdade())
                .cpf(clienteRequestDto.getCpf())
                .genero(clienteRequestDto.getGenero())
                .telefone(clienteRequestDto.getTelefone())
                .email(clienteRequestDto.getEmail())
                .senha(senhaCripto)
                .idPlano(clienteRequestDto.getIdPlano())
                .build();

        LOGGER.info("Salvando o cliente.");
        clienteRepository.cadastrarNovoCliente(cliente);
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public void agendarTreino(AgendamentoRequestDto agendamentoRequestDto) {
        LOGGER.info("Início do método agendarTreino da command para um cliente.");

        LOGGER.info("Construindo o cliente para agendamento de um treino.");
        Agendamento agendamento = Agendamento
                .builder()
                .idCliente(agendamentoRequestDto.getIdCliente())
                .idTreino(agendamentoRequestDto.getIdTreino())
                .data(agendamentoRequestDto.getData())
                .hora(agendamentoRequestDto.getHora())
                .build();

        LOGGER.info("Salvando os dados.");
        clienteRepository.agendarTreino(agendamento);
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public void atualizarAgendamentoDeTreino(AgendamentoRequestDto agendamentoRequestDto) {
        LOGGER.info("Início do método ataulizarAgendamentoDeTreino da command para um cliente.");

        LOGGER.info("Construindo o dados para atualizar o agendamento de um treino.");
        Agendamento agendamento = Agendamento
                .builder()
                .idAgendamento(agendamentoRequestDto.getIdAgendamento())
                .novoTreino(agendamentoRequestDto.getNovoTreino())
                .data(agendamentoRequestDto.getData())
                .hora(agendamentoRequestDto.getHora())
                .build();

        LOGGER.info("Salvando os dados.");
        clienteRepository.atualizarAgendamentoDeTreino(agendamento);
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public void excluirAgendamentoAtivo(AgendamentoRequestDto agendamentoRequestDto) {
        LOGGER.info("Início do método excluirAgendamentoAtivo da command para um cliente.");

        LOGGER.info("Construindo o dados para atualizar o agendamento de um treino.");
        Agendamento agendamento = Agendamento.builder()
                .idAgendamento(agendamentoRequestDto.getIdAgendamento())
                .build();

        LOGGER.info("Salvando os dados.");
        clienteRepository.excluirAgendamentoAtivo(agendamento);
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public List<ClienteResponseDto> buscarClientePorNome(String primeiroNome) {
        LOGGER.info("Início do método buscarClientePorNome da command para um cliente.");
        return clienteRepository.buscarDadosPessoaisPeloPrimeiroNome(primeiroNome);
    }

    //--------------------------------------------------------------------------------------------------------------------//

}
