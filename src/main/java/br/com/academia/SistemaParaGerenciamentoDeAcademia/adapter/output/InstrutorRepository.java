package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.Instrutor.dto.AgendamentosDoDiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IInstrutorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstrutorRepository implements IInstrutorRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstrutorRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void efetuarLoginInstrutor(Instrutor instrutor) {
        LOGGER.info("Início do método para efetuar login de um instrutor - repository.");
        try {
            String sql = "SELECT * FROM login_instrutor(?,?)";

            jdbcTemplate.execute(sql, (PreparedStatementCallback<Void>) preparedStatement -> {
                preparedStatement.setString(1, instrutor.getCpf());
                preparedStatement.setString(2, instrutor.getSenha());
                preparedStatement.execute();
                return null;
            });
        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new NegocioException("Erro ao logar.");
        }
    }

    @Override
    public List<AgendamentosDoDiaResponseDto> listarAgendamentoDoDia() {
        LOGGER.info("Início do método para listar agendamentos do dia - repository.");
        try {
            String sql = "SELECT * FROM listar_agendamentos_hoje()";

            return jdbcTemplate.query(sql, new Object[]{}, (rs, rowNum) -> {
                AgendamentosDoDiaResponseDto agendamentos = new AgendamentosDoDiaResponseDto();
                agendamentos.setId(rs.getString("id"));
                agendamentos.setClienteNome(rs.getString("cliente_nome"));
                agendamentos.setTreinoNome(rs.getString("treino_nome"));
                return agendamentos;
            });

        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new NegocioException("Erro ao listar agendamento do dia.");
        }
    }
}
