package vuce.gob.pe.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vuce.gob.pe.app.dto.TrasmisionDTO;

public class TramisionRowMapper  implements RowMapper<TrasmisionDTO> {

	@Override
	public TrasmisionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrasmisionDTO transmision = new TrasmisionDTO();
		transmision.setCodigoEntidad(rs.getInt(1));
		transmision.setSiglaEntidad(rs.getString(2));
		transmision.setCantidadTrasmisionEntrada(rs.getInt(3));
		transmision.setCantidadTrasmisionSalida(rs.getInt(4));
		return transmision;
	}

}
