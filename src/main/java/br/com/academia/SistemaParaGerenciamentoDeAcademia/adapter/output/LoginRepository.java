package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.CustomExeption;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioBancoException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.ILoginRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.ConstantesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository implements ILoginRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Cliente existePessoa(String cpf) {
        LOGGER.info("Início do método para verificar se existe pessoa - repository.");
        try{
            String sql = "SELECT * FROM obter_usuario_por_cpf(?)";

            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Cliente.class), cpf);

        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            throw new NegocioBancoException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new CustomExeption(ConstantesUtils.ERRO_VERIFICAR_PESSOA);
        }
    }
}
