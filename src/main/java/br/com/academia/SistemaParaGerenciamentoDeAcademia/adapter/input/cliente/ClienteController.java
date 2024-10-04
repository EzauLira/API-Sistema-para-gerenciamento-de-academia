package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadrao;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemSucessoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ICliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ICliente clienteCommand;

    @PostMapping("/cadastrar")
    public ResponseEntity<RespostaPadrao> cadastrarNovocliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método para cadastrar um novo cliente");
        long startTime = System.currentTimeMillis();

        clienteCommand.cadastrarNovoCliente(clienteRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadrao.builder()
                        .mensagem(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem())
                        .build());
    }

}
