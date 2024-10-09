package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.AgendamentoRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemSucessoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ICliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.ILogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController implements IClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ICliente clienteCommand;

    @Autowired
    ILogin iLogin;

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @PostMapping("/cadastrar")
    public ResponseEntity<RespostaPadraoDto> cadastrarNovoCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método para cadastrar um novo cliente");
        long startTime = System.currentTimeMillis();

        clienteCommand.cadastrarNovoCliente(clienteRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.CADASTRO_EFETUADO.getMensagem())
                        .build());
    }

    //--------------------------------------------------------------------------------------------------------------------//

//    @Override
//    @PostMapping("/logar")
//    public ResponseEntity<RespostaPadraoDto> efetuarLogin(@RequestBody LoginRequestDto loginRequestDto) {
//        LOGGER.info("Inicio do método para efetuar login - Controller");
//
//        long startTime = System.currentTimeMillis();
//
//        iLogin.login(loginRequestDto);
//
//        long endTime = System.currentTimeMillis();
//        long elapsedTime = endTime - startTime;
//        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);
//
//        return ResponseEntity.ok(
//                RespostaPadraoDto.builder()
//                        .mensagem(MensagemSucessoEnum.LOGIN_CLIENTE_EFETUADO.getMensagem())
//                        .build());
//    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @PostMapping("/agendar")
    public ResponseEntity<RespostaPadraoDto> agendarTreino(@RequestBody AgendamentoRequestDto agendamentoRequestDto){
        LOGGER.info("Inicio do método para agendar treino - Controller");

        long startTime = System.currentTimeMillis();

        clienteCommand.agendarTreino(agendamentoRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.TREINO_AGENDADO.getMensagem())
                        .build());
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @PutMapping("/atualizar-agendamento")
    public ResponseEntity<RespostaPadraoDto> atualizarAgendamentoDeTreino(@RequestBody AgendamentoRequestDto agendamentoRequestDto){
        LOGGER.info("Inicio do método para atualizar o agendamento de um treino - Controller");

        long startTime = System.currentTimeMillis();

        clienteCommand.atualizarAgendamentoDeTreino(agendamentoRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.TREINO_ATUALIZADO.getMensagem())
                        .build());
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @DeleteMapping("/excluir-agendamento")
    public ResponseEntity<RespostaPadraoDto> excluirAgendamentoAtivo(@RequestBody AgendamentoRequestDto agendamentoRequestDto){
        LOGGER.info("Inicio do método para excluir um agendamento ativo - Controller");

        long startTime = System.currentTimeMillis();

        clienteCommand.excluirAgendamentoAtivo(agendamentoRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.TREINO_EXCLUIDO.getMensagem())
                        .build());
    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @GetMapping("/buscar")
    public List<ClienteResponseDto> buscarPorNome(@RequestBody ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Início do método para buscar um cliente pelo nome - Controller");
        return clienteCommand.buscarClientePorNome(clienteRequestDto.getNome());
    }

    //--------------------------------------------------------------------------------------------------------------------//
}
