package vuce.gob.pe.app.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vuce.gob.pe.app.dto.TrasmisionIncidenteDTO;

public class TramisionIncidenteRowMapper  implements RowMapper<TrasmisionIncidenteDTO> {

	@Override
	public TrasmisionIncidenteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrasmisionIncidenteDTO transmision = new TrasmisionIncidenteDTO();
		transmision.setCodigoEntidad(rs.getInt(1));
		transmision.setSiglaEntidad(rs.getString(2));
		transmision.setCantidadTrasmisionEntrada(rs.getInt(3));
		transmision.setCantidadTrasmisionSalida(rs.getInt(4));
		return transmision;
	}

}
