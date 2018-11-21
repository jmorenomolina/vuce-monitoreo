package vuce.gob.pe.app.service;

import java.math.BigDecimal;
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

import vuce.gob.pe.app.dto.MensajeSalidaDTO;
import vuce.gob.pe.app.dto.RequestFiltrarTransmisionesDTO;
import vuce.gob.pe.app.dto.TrasmisionDTO;
import vuce.gob.pe.app.dto.TrasmisionIncidenteDTO;
import vuce.gob.pe.app.repository.TransmisionesRepository;
import vuce.gob.pe.app.service.mapper.TramisionIncidenteRowMapper;
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
	public List<TrasmisionIncidenteDTO> obtenerTransmisionesConIncidente(Date fechaInicio, Date fechaFin) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName(FUN_OBTENER_TX_CON_INCIDENTE)
				.returningResultSet(FUN_OBTENER_TX_CON_INCIDENTE_RETURN, new TramisionIncidenteRowMapper());
		SqlParameterSource in = new MapSqlParameterSource()
										.addValue("fecha_incio", fechaInicio)
										.addValue("fecha_fin",fechaFin);
		Map<String, Object> result = simpleJdbcCall.execute(in);
		return (List) result.get(FUN_OBTENER_TX_CON_INCIDENTE_RETURN);
	}
	
	
	private final String PC_FILTRAR_TRANSMISIONES = "FILTRAR_TRANSMISIONES";
	private final String PC_OBTENER_TX_CON_INCIDENTE_RETURN = "TCURSOR";
	@Override
	public List<TrasmisionDTO> filtrarTransmisiones(RequestFiltrarTransmisionesDTO request) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(PC_FILTRAR_TRANSMISIONES)
				.returningResultSet(PC_OBTENER_TX_CON_INCIDENTE_RETURN, new TramisionRowMapper());
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("CODIGO_ENTIDAD", request.getCodigoEntidad())
				.addValue("FECHA_INICIO",request.getFechaFin())
				.addValue("FECHA_FIN",request.getFechaFin())
				.addValue("TIPO_MENSAJE",request.getTipoMensaje())
				.addValue("TIPO_DOCUMENTO",request.getTipoDocumento())
				.addValue("NUMERO_DOCUMENTO",request.getNumeroDocumento())
				.addValue("TIPO_TRANSMISION",request.getTipoTransmision())
				.addValue("TIPO_INCIDENTE",request.getTipoIncidente())
				.addValue("ESTADO_VC",request.getEstadoVc())
				.addValue("ESTADO_VE",request.getEstadoVe())
				.addValue("VC_ID",request.getVcId())
				.addValue("VE_ID",request.getVeId());
		Map<String, Object> result = simpleJdbcCall.execute(in);
		return (List) result.get(PC_OBTENER_TX_CON_INCIDENTE_RETURN);
	}
	
	private final String REENVIAR_TX_SALIDA_CON_ERROR = "REENVIAR_TX_SALIDA_CON_ERROR";
	@Override
	public MensajeSalidaDTO reenviarTransaccionSalidaConError(Integer vcId,String vcTransaccion,Integer veId, String veTransaccion) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(REENVIAR_TX_SALIDA_CON_ERROR);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("VC_ID", vcId)
		        .addValue("VC_TRANSACCION",vcTransaccion)
		        .addValue("VE_ID",veId)
		        .addValue("VE_TRANSACCION",veTransaccion);
		Map<String, Object> result = simpleJdbcCall.execute(in);		
		MensajeSalidaDTO mensaje = new MensajeSalidaDTO();	
		BigDecimal resultadoValor = (BigDecimal) result.get("RESULTADO_VALOR");
		mensaje.setResultadoValor(resultadoValor.intValueExact());
		mensaje.setResultadoMensaje((String) result.get("RESULTADO_MENSAJE"));
		return mensaje;
	}
	
	private final String HABILITAR_TRANSMISIONES = "HABILITAR_TRANSMISIONES";
	@Override
	public MensajeSalidaDTO habilitarTransmision(Integer veId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(HABILITAR_TRANSMISIONES);
		SqlParameterSource in = new MapSqlParameterSource()
		        .addValue("VE_ID",veId);
		Map<String, Object> result = simpleJdbcCall.execute(in);		
		MensajeSalidaDTO mensaje = new MensajeSalidaDTO();	
		BigDecimal resultadoValor = (BigDecimal) result.get("RESULTADO_VALOR");
		mensaje.setResultadoValor(resultadoValor.intValueExact());
		mensaje.setResultadoMensaje((String) result.get("RESULTADO_MENSAJE"));
		return mensaje;
	}

}
