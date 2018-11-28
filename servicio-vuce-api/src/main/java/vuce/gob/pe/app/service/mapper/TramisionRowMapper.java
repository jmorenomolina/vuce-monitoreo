package vuce.gob.pe.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import vuce.gob.pe.app.dto.TrasmisionDTO;

public class TramisionRowMapper  implements RowMapper<TrasmisionDTO> {

	@Override
	public TrasmisionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrasmisionDTO transmision = new TrasmisionDTO();
		transmision.setTipo(rs.getString("TIPO"));	
		transmision.setTieneIncidente(rs.getInt("TIENE_INCIDENTE"));
		transmision.setTipoIncidente(rs.getInt("TIPO_INCIDENTE"));
		transmision.setEntidadId(rs.getInt("ENTIDAD_ID"));
		transmision.setEntidadSigla(rs.getString("ENTIDAD_ID"));
		transmision.setTipoMensaje(rs.getString("TIPO_MENSAJE"));
		transmision.setNombreMensaje(rs.getString("NOM_MENSAJE"));
		//transmision.setXml(rs.getString(8));
		//transmision.setEbxml(rs.getString(9));
		transmision.setError(rs.getString(10));
		transmision.setVcId(rs.getInt(11));
		transmision.setVeId(rs.getInt(12));
		transmision.setNombreEstadoVc(rs.getString(13));
		transmision.setEstadoVe(rs.getInt(14));
		transmision.setNombreEstadoVe(rs.getString(15));
		transmision.setTipoDocumento(rs.getString(16));
		transmision.setNombreDocumento(rs.getString(17));
		transmision.setNumeroDocumento(rs.getString(18));
		transmision.setFechaRegistroSalida(rs.getDate(19));
		transmision.setFechaActualizacionSalida(rs.getDate(20));
		transmision.setAntiguedadSalida(rs.getInt(21));
		transmision.setFormato(rs.getString(22));
		transmision.setFechaRegistroEntrada(rs.getDate(23));
		transmision.setFechaActualizacionEntrada(rs.getDate(24));
		transmision.setAntiguedadEntrada(rs.getInt(25));
		
		transmision.setEstadoVc(rs.getInt("ESTADO_VC"));
		
		
		return transmision;
	}

}
