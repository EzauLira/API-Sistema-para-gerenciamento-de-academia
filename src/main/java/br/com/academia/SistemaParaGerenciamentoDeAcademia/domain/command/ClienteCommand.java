package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
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
        LOGGER.info("Inicio do método cadastrarNovoCliente da command para cadastro de um cliente.");


        LOGGER.info("Validando as infomações do cliente.");
        ValidarNomeUtils.validarNome(clienteRequestDto.getNome());
        ValidarIDadeUtils.validarIdade(clienteRequestDto.getIdade());
        ValidarCpfUtils.validarCpf(clienteRequestDto.getCpf());
        ValidarTelefoneUtils.validarTelefone(clienteRequestDto.getTelefone());
        ValidarEmailUtils.validarEmail(clienteRequestDto.getEmail());

        LOGGER.info("Construindo usuario");
        Cliente cliente = Cliente.builder()
                .nome(clienteRequestDto.getNome())
                .idade(clienteRequestDto.getIdade())
                .cpf(clienteRequestDto.getCpf())
                .genero(clienteRequestDto.getGenero())
                .telefone(clienteRequestDto.getTelefone())
                .email(clienteRequestDto.getEmail())
                .senha(clienteRequestDto.getSenha())
                .idPlano(clienteRequestDto.getIdPlano())
                .planoNome(clienteRequestDto.getPlanoNome())
                .build();

        iClienteRepository.cadastrarNovoCliente(cliente);
    }
}
