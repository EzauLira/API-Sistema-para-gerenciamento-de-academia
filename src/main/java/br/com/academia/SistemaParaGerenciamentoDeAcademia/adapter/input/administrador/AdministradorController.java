package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.enun.MensagemSucessoEnum;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.input.IAdministrador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/adm")
public class AdministradorController implements IAdministradorController{

    private static final Logger LOGGER = LoggerFactory.getLogger(AdministradorController.class);

    @Autowired
    IAdministrador administradorCommand;

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @PostMapping("/cadastrar-instrutor")
    public ResponseEntity<RespostaPadraoDto> cadastrarNovoInstrutor(@RequestBody InstrutorRequestDto instrutorRequestDto) {
        LOGGER.info("Início do método para cadastrar um novo cliente");
        long startTime = System.currentTimeMillis();

       administradorCommand.cadastrarNovoInstrutor(instrutorRequestDto);

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
//                        .mensagem(MensagemSucessoEnum.LOGIN_ADM_EFETUADO.getMensagem())
//                        .build());
//    }

    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    @GetMapping("/buscar-estatistica")
    public List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia() {
        LOGGER.info("Início do método para listar estatísticas da academia");
        return administradorCommand.listarEstatisticasDaAcademia();
    }
}
