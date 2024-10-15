package br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.output;

import br.com.academia.SistemaParaGerenciamentoDeAcademia.adapter.input.administrador.dto.EstatisticasAcademiaResponseDto;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.entities.Instrutor;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.CustomExeption;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.domain.exception.NegocioBancoException;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.port.output.IAdministradorRepository;
import br.com.academia.SistemaParaGerenciamentoDeAcademia.utils.ConstantesUtils;
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
            throw new NegocioBancoException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new CustomExeption(ConstantesUtils.ERRO_AO_CADASTRAR_INSTRUTOR);
        }
    }

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
            throw new NegocioBancoException(e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            LOGGER.error("Exception: {}", e.getMessage(), e);
            throw new CustomExeption(ConstantesUtils.ERRO_AO_LISTAR_ESTATISTICAS);
        }
    }

    //--------------------------------------------------------------------------------------------------------------------//
}
