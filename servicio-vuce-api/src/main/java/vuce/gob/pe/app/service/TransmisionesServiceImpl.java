package vuce.gob.pe.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.repository.TransmisionesRepository;
import vuce.gob.pe.app.service.mapper.TramisionRowMapper;

/**
 *
 * @author cquevedo
 */
@Service
public class TransmisionesServiceImpl implements TransmisionesService {

	@Autowired
	private TransmisionesRepository transmisionesRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	private final String FUN_OBTENER_TX_CON_INCIDENTE = "OBTENER_TX_CON_INCIDENTE";
	private final String FUN_OBTENER_TX_CON_INCIDENTE_RETURN = "resp_cursor";

	@Override
	public List<TrasmisionDTO> obtenerTransmisionesConIncidente(Date fechaInicio, Date fechaFin) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName(FUN_OBTENER_TX_CON_INCIDENTE)
				.returningResultSet(FUN_OBTENER_TX_CON_INCIDENTE_RETURN, new TramisionRowMapper());
		SqlParameterSource in = new MapSqlParameterSource()
										.addValue("fecha_incio", fechaInicio)
										.addValue("fecha_fin",fechaFin);
		Map<String, Object> result = simpleJdbcCall.execute(in);
		return (List) result.get(FUN_OBTENER_TX_CON_INCIDENTE_RETURN);
	}

}
