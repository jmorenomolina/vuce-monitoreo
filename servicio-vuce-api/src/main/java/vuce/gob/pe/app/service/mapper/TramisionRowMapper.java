package vuce.gob.pe.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import vuce.gob.pe.app.dto.TrasmisionDTO;

public class TramisionRowMapper  implements RowMapper<TrasmisionDTO> {
	
	LobHandler lobHandler = new DefaultLobHandler();
	
	@Override
	public TrasmisionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrasmisionDTO transmision = new TrasmisionDTO();
		transmision.setTipo(rs.getString("TIPO"));	
		transmision.setTieneIncidente(rs.getInt("TIENE_INCIDENTE"));
		transmision.setTipoIncidente(rs.getInt("TIPO_INCIDENTE"));
		transmision.setEntidadId(rs.getInt("ENTIDAD_ID"));
		transmision.setEntidadSigla(rs.getString("SIGLA_ENTIDAD"));
		transmision.setTipoMensaje(rs.getString("TIPO_MENSAJE"));
		transmision.setNombreMensaje(rs.getString("NOM_MENSAJE"));
		
		byte[] requestXmlData = lobHandler.getBlobAsBytes(rs,"XML");
		if(requestXmlData!=null) {
			transmision.setXml(new String(requestXmlData));
		}
	
		byte[] requestEbxmlData = lobHandler.getBlobAsBytes(rs,"EBXML");
		if(requestEbxmlData!=null) {
			transmision.setEbxml(new String(requestEbxmlData));
		}
		
		transmision.setError(rs.getString("ERROR"));
		transmision.setVcId(rs.getInt("VC_ID"));
		transmision.setVeId(rs.getInt("VE_ID"));
		transmision.setEstadoVc(rs.getInt("ESTADO_VC"));		
		transmision.setNombreEstadoVc(rs.getString("NOM_ESTADO_VC"));		
		transmision.setEstadoVe(rs.getInt("ESTADO_VE"));
		transmision.setNombreEstadoVe(rs.getString("NOM_ESTADO_VE"));
		transmision.setTipoDocumento(rs.getString("TIPO_DOC"));
		transmision.setNombreDocumento(rs.getString("NOM_DOC"));
		transmision.setNumeroDocumento(rs.getString("NUM_DOC"));		
		transmision.setFechaRegistroSalida(rs.getDate("FECHA_REGISTRO_SALIDA"));
		transmision.setFechaActualizacionSalida(rs.getDate("FECHA_ACTUALIZACION_SALIDA"));
		transmision.setAntiguedadSalida(rs.getInt("ANTIGUEDAD_SALIDA"));
		transmision.setFormato(rs.getString("FORMATO"));
		transmision.setFechaRegistroEntrada(rs.getDate("FECHA_REGISTRO_ENTRADA"));
		transmision.setFechaActualizacionEntrada(rs.getDate("FECHA_ACTUALIZACION_ENTRADA"));
		transmision.setAntiguedadEntrada(rs.getInt("ANTIGUEDAD_ENTRADA"));		
		return transmision;
	}

}
