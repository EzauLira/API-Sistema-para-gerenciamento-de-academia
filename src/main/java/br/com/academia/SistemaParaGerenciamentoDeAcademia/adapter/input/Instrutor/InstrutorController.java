package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.cliente.dto.ClienteRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemSucessoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.IInstrutor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/instrutor")
public class InstrutorController implements IInstrutorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstrutorController.class);

    @Autowired
    IInstrutor instrutorCommand;

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Override
    @PostMapping("/logar")
    public ResponseEntity<RespostaPadraoDto> efetuarLoginInstrutor(@RequestBody InstrutorRequestDto instrutorRequestDto) {
        LOGGER.info("Inicio do método para efetuar login instrutor - Controller");

        long startTime = System.currentTimeMillis();

        instrutorCommand.efetuarLoginInstrutor(instrutorRequestDto);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        LOGGER.info("Tempo decorrido: {} milissegundos", elapsedTime);

        return ResponseEntity.ok(
                RespostaPadraoDto.builder()
                        .mensagem(MensagemSucessoEnum.LOGIN_EFETUADO.getMensagem())
                        .build());
    }

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Override
    @PostMapping("/agendamento-dia")
    public List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia(){
        LOGGER.info("Inicio do método para listar agendamento do dia - Controller");
        return instrutorCommand.listarAgendamentoDoDia();
    }

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Override
    @GetMapping("/agendamento-especifico")
    public List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(@RequestBody ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Inicio do método para listar treinos de um cliente específico - Controller");
        return instrutorCommand.listarTreinosDeUmClienteEspecifico(clienteRequestDto.getNome());
    }

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Override
    @GetMapping("/historico")
    public List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(@RequestBody ClienteRequestDto clienteRequestDto) {
        LOGGER.info("Inicio do método para buscar histórico de um cliente específico - Controller");
        return instrutorCommand.buscarHistoricoDeUmClienteEspecifico(clienteRequestDto.getNome());
    }

    //------------------------------------------------------------------------------------------------------------------------------------//
}
