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
    public ResponseEntity<RespostaPadrao> cadastrarNovoCliente(ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método cadastrarNovoCliente da command para cadastro de um cliente.");

        LOGGER.info("Verificando se o cliente existe no banco de dados.");
        Boolean clienteExiste = iClienteRepository.verificarSeClienteExiste(clienteRequestDto.getCpf());
        if (clienteExiste){
            RespostaPadrao respostaErro = RespostaPadrao.builder()
                    .mensagem(MensagemErroEnum.CLIENTE_JA_EXISTE.getMensagem())
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respostaErro);
        }

        LOGGER.info("Validando as informações do cliente.");
        ValidarNomeUtils.validarNome(clienteRequestDto.getNome());
        ValidarIDadeUtils.validarIdade(clienteRequestDto.getIdade());
        ValidarCpfUtils.validarCpf(clienteRequestDto.getCpf());
        ValidarTelefoneUtils.validarTelefone(clienteRequestDto.getTelefone());
        ValidarEmailUtils.validarEmail(clienteRequestDto.getEmail());

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

        RespostaPadrao respostaSucesso = RespostaPadrao.builder()
                .mensagem("Cliente cadastrado com sucesso.")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(respostaSucesso);
    }
}
