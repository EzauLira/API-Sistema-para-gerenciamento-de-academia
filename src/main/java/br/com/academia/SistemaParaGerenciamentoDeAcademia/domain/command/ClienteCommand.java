package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ICliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ClienteCommand implements ICliente {

   private static final Logger LOGGER = LoggerFactory.getLogger(ClienteCommand.class);

   @Autowired
   IClienteRepository iClienteRepository;


    @Override
    public void cadastrarNovoCliente(ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método cadastrarNovoCliente da command para cadastro de um cliente.");

        LOGGER.info("Verificando se o cliente existe no banco de dados.");
        if (iClienteRepository.verificarSeClienteExiste(clienteRequestDto.getCpf(),
                clienteRequestDto.getNome(), clienteRequestDto.getTelefone(), clienteRequestDto.getEmail())){
            throw new NegocioException(MensagemErroEnum.CLIENTE_JA_EXISTE.getMensagem());
        }

        //Colocar validador para verificar se o telefone já existe.
        //Colocar validador para verificar se o nome já existe.
        //Colocar validador para verificar se o email já existe.

        LOGGER.info("Validando as informações do cliente.");
        ValidarNomeUtils.validarNome(clienteRequestDto.getNome());
        ValidarIDadeUtils.validarIdade(clienteRequestDto.getIdade());
        ValidarCpfUtils.validarCpf(clienteRequestDto.getCpf());
        ValidarTelefoneUtils.validarTelefone(clienteRequestDto.getTelefone());
        ValidarEmailUtils.validarEmail(clienteRequestDto.getEmail());
        ValidarSenhaUtils.validarSenha(clienteRequestDto.getSenha());

        LOGGER.info("Construindo o cliente.");
        Cliente cliente = Cliente.builder()
                .nome(clienteRequestDto.getNome())
                .idade(clienteRequestDto.getIdade())
                .cpf(clienteRequestDto.getCpf())
                .genero(clienteRequestDto.getGenero())
                .telefone(clienteRequestDto.getTelefone())
                .email(clienteRequestDto.getEmail())
                .senha(clienteRequestDto.getSenha())
                .idPlano(clienteRequestDto.getIdPlano())
                .build();

        LOGGER.info("Salvando o cliente.");
        iClienteRepository.cadastrarNovoCliente(cliente);
    }
}
