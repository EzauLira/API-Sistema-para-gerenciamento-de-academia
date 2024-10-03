package br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.command;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadrao;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemErroEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ICliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.validadores.*;
import ch.qos.logback.core.net.server.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteCommand implements ICliente {

   private static final Logger LOGGER = LoggerFactory.getLogger(ClienteCommand.class);

   @Autowired
   IClienteRepository iClienteRepository;


    @Override
    public String cadastrarNovoCliente(ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Inicio do método cadastrarNovoCliente da command para cadastro de um cliente.");

        Cliente clienteExiste = iClienteRepository.verificarSeClienteExiste(clienteRequestDto.getCpf());
        if (clienteExiste != null){
            return String.valueOf(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }


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
        return "sucesso.";
    }

}
