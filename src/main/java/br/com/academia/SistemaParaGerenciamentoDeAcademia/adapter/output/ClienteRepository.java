package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteRepository implements IClienteRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Override
//    @Transactional
//    public void cadastrarNovoCliente(Cliente cliente) {
//        LOGGER.info("Inicio do método para cadastrar um novo cliente.");
//        try {
//            String sql = "SELECT cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";
//
//            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("cadastrar_cliente");
//
//            Map<String, Object> input = new HashMap<>();
//            input.put("p_nome", cliente.getNome());
//            input.put("p_idade", cliente.getIdade());
//            input.put("p_cpf", cliente.getCpf());
//            input.put("p_genero", cliente.getGenero());
//            input.put("p_telefone", cliente.getTelefone());
//            input.put("p_email", cliente.getEmail());
//            input.put("p_senha", cliente.getSenha());
//            input.put("p_plano_id", cliente.getIdPlano());
//
//            Map<String, Object> output = call.execute(input);
//
//
//        } catch (DataAccessException e) {
//            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
//            System.out.println(e.getMostSpecificCause().getMessage());
//            throw new NegocioException(e.getMostSpecificCause().getMessage());
//
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }

    @Override
    @Transactional
    public void cadastrarNovoCliente(Cliente cliente) {
        LOGGER.info("Início do método para cadastrar um novo cliente repository.");
        try {
            String sql = "SELECT cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.execute(sql, (PreparedStatementCallback<Void>) preparedStatement -> {
                preparedStatement.setString(1, cliente.getNome());
                preparedStatement.setInt(2, cliente.getIdade());
                preparedStatement.setString(3, cliente.getCpf());
                preparedStatement.setInt(4, cliente.getGenero());
                preparedStatement.setString(5, cliente.getTelefone());
                preparedStatement.setString(6, cliente.getEmail());
                preparedStatement.setString(7, cliente.getSenha());
                preparedStatement.setInt(8, cliente.getIdPlano());
                preparedStatement.execute();
                return null;
            });
        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            System.out.println(e.getMostSpecificCause().getMessage());
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean verificarSeClienteExiste(String cpf, String nome, String telefone, String email) {
        String sql = "SELECT * FROM pessoa_existe(?,?,?,?)";
        return Boolean.TRUE.equals(jdbcTemplate.queryForObject(sql, Boolean.class, cpf, nome, telefone, email));
    }


}
