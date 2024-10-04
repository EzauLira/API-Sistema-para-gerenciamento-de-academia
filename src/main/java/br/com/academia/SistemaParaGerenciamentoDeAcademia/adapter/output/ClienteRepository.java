package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.SqlException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository implements IClienteRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void cadastrarNovoCliente(Cliente cliente) {
        LOGGER.info("Inicio do método para cadastrar um novo cliente.");
        try {
            String sql = "SELECT cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";

            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("cadastrar_cliente");

            Map<String, Object> input = new HashMap<>();
            input.put("p_nome", cliente.getNome());
            input.put("p_idade", cliente.getIdade());
            input.put("p_cpf", cliente.getCpf());
            input.put("p_genero", cliente.getGenero());
            input.put("p_telefone", cliente.getTelefone());
            input.put("p_email", cliente.getEmail());
            input.put("p_senha", cliente.getSenha());
            input.put("p_plano_id", cliente.getIdPlano());

            Map<String, Object> output = call.execute(input);


        } catch (DataAccessException e) {
          e.getMessage();
        }catch (Exception e){
            e.getMessage();
        }
    }

//    public void cadastrarNovoCliente(Cliente cliente) {
//        LOGGER.info("Início do método para cadastrar um novo cliente.");
//        String sql = "SELECT cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.execute(sql, (PreparedStatementCallback<?>) PreparedStatement -> {
//                PreparedStatement.setString(1, cliente.getNome());
//                PreparedStatement.setInt(2, cliente.getIdade());
//                PreparedStatement.setString(3, cliente.getCpf());
//                PreparedStatement.setInt(4, cliente.getGenero());
//                PreparedStatement.setString(5, cliente.getTelefone());
//                PreparedStatement.setString(6, cliente.getEmail());
//                PreparedStatement.setString(7, cliente.getSenha());
//                PreparedStatement.setInt(8, cliente.getIdPlano());
//                return null;
//            });
//
//            LOGGER.info("Cliente cadastrado com sucesso.");
//        } catch (DataAccessException e) {
//            LOGGER.error("Erro de acesso a dados: " + e.getMessage());
//            throw new NegocioException("Erro ao acessar dados do cliente.");
//        } catch (Exception e) {
//            LOGGER.error("Erro ao cadastrar cliente: " + e.getMessage());
//            throw new NegocioException("Erro ao cadastrar cliente.");
//        }
//    }



    public boolean verificarSeClienteExiste(String cpf, String nome, String telefone, String email) {
        String sql = "SELECT * FROM pessoa_existe(?,?,?,?)";
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(sql, Boolean.class, cpf, nome, telefone, email));
    }


}
