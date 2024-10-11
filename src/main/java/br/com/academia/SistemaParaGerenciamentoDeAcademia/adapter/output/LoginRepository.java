package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.login.dto.LoginRequestDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.ILoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements ILoginRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void login(LoginRequestDto loginRequestDto) {
        LOGGER.info("Início do método para efetuar login de um instrutor - repository.");
        try {
            String sql = "SELECT * FROM login(?,?)";

            jdbcTemplate.execute(sql, (PreparedStatementCallback<Void>) preparedStatement -> {
                preparedStatement.setString(1, loginRequestDto.getCpf());
                preparedStatement.setString(2, loginRequestDto.getSenha());
                preparedStatement.execute();
                return null;
            });

        } catch (DataAccessException e) {
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            throw new NegocioException("Erro ao logar.");
        }
    }

    @Override
    public Cliente existePessoa(String cpf) {
        LOGGER.info("Início do método para verificar se existe pessoa - repository.");
        try{
            String sql = "SELECT * FROM obter_usuario_por_cpf(?)";

            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cliente.class), cpf);

        } catch (DataAccessException e) {
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            throw new NegocioException("Erro ao verificar pessoa.");
        }

    }
}
