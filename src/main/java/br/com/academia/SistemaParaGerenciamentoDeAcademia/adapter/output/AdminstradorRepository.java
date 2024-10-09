package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IAdministradorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminstradorRepository implements IAdministradorRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminstradorRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    //--------------------------------------------------------------------------------------------------------------------//

    @Override
    public void cadastrarNovoInstrutor(Instrutor instrutor) {
        LOGGER.info("Início do método para cadastrar um novo instrutor - repository.");
        try {
            String sql = "SELECT cadastrar_instrutor(?, ?, ?, ?, ?, ?)";
            jdbcTemplate.execute(sql, (PreparedStatementCallback<Void>) preparedStatement -> {
                preparedStatement.setString(1, instrutor.getNome());
                preparedStatement.setString(2, instrutor.getCpf());
                preparedStatement.setInt(3, instrutor.getGenero());
                preparedStatement.setString(4, instrutor.getTelefone());
                preparedStatement.setString(5, instrutor.getEmail());
                preparedStatement.setString(6, instrutor.getSenha());
                preparedStatement.execute();
                return null;
            });
        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new NegocioException("Erro ao cadastrar cliente.");
        }
    }

    //--------------------------------------------------------------------------------------------------------------------//


//    @Override
//    public void efetuarLogin(Administrador administrador) {
//        LOGGER.info("Início do método para efetuar login de um ADM - repository.");
//        try {
//            String sql = "SELECT * FROM login_admin(?,?)";
//
//            jdbcTemplate.execute(sql, (PreparedStatementCallback<Void>) preparedStatement -> {
//                preparedStatement.setString(1, administrador.getUsuario());
//                preparedStatement.setString(2, administrador.getSenha());
//                preparedStatement.execute();
//                return null;
//            });
//        } catch (DataAccessException e) {
//            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
//            throw new NegocioException(e.getMostSpecificCause().getMessage());
//        } catch (Exception e) {
//            LOGGER.error("Exception: {}", e.getMessage(), e);
//            throw new NegocioException("Erro ao logar cliente.");
//        }
//    }

    //--------------------------------------------------------------------------------------------------------------------//


    @Override
    public List<EstatisticasAcademiaResponseDto> listarEstatisticasDaAcademia() {
        LOGGER.info("Início do método para listar estatisticas da academia - repository.");
        try {
            String sql = "SELECT * FROM gerar_relatorio_academia()";

            return jdbcTemplate.query(sql, new Object[]{}, (rs, rowNum) -> {
                EstatisticasAcademiaResponseDto estatistica = new EstatisticasAcademiaResponseDto();
                estatistica.setTotalClientes(rs.getString("total_clientes"));
                estatistica.setPlanoMensalVendido(rs.getString("plano_mensal_vendido"));
                estatistica.setPlanoAnualVendido(rs.getString("plano_anual_vendido"));
                estatistica.setPlanoTrimestralVendido(rs.getString("plano_trimestral_vendido"));
                return estatistica;
            });

        } catch (DataAccessException e) {
            LOGGER.error("DataAccessException: {}", e.getMessage(), e);
            throw new NegocioException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new NegocioException("Erro ao agendar treino.");
        }
    }


    //--------------------------------------------------------------------------------------------------------------------//

}
