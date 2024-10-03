package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Cliente;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements IClienteRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void cadastrarNovoCliente(Cliente cliente){
    LOGGER.info("Inicio do método para cadastrar um novo cliente.");
    try {
        String sql = "SELECT cadastrar_cliente(?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                cliente.getNome(),
                cliente.getIdade(),
                cliente.getCpf(),
                cliente.getGenero(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getSenha(),
                cliente.getIdPlano()
        );
    }catch (DataAccessException e){
        e.printStackTrace();
    }
    }
}
