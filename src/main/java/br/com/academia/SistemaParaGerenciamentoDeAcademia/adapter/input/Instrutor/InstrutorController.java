package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.IInstrutor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/instrutor")
public class
InstrutorController implements IInstrutorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstrutorController.class);

    @Autowired
    IInstrutor instrutorCommand;

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
    public List<AgendamentosDoDiaResponseDto> listarTreinosDeUmClienteEspecifico(@RequestParam String nome) {
        LOGGER.info("Inicio do método para listar treinos de um cliente específico - Controller");
        return instrutorCommand.listarTreinosDeUmClienteEspecifico(nome);
    }

    //------------------------------------------------------------------------------------------------------------------------------------//

    @Override
    @GetMapping("/historico")
    public List<AgendamentosDoDiaResponseDto> buscarHistoricoDeUmClienteEspecifico(@RequestParam String nome) {
        LOGGER.info("Inicio do método para buscar histórico de um cliente específico - Controller");
        return instrutorCommand.buscarHistoricoDeUmClienteEspecifico(nome);
    }

    //------------------------------------------------------------------------------------------------------------------------------------//
}
