package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.InstrutorRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.config.dto.RespostaPadraoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IInstrutorController {

    ResponseEntity<RespostaPadraoDto> efetuarLoginInstrutor(InstrutorRequestDto instrutorRequestDto);

    List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia();
}
