package pe.gob.vuce.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.gob.vuce.model.ViewDetalleTransacciones;
import pe.gob.vuce.repository.ViewDetalleTransaccionesRepository;

@Named
@ViewScoped
public class ViewDetalleTransaccionesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<ViewDetalleTransacciones> detalleTransacciones;

	@Inject
	private final ViewDetalleTransaccionesRepository repository = null;

	public List<ViewDetalleTransacciones> getViewDetalleTransacciones() {
		return detalleTransacciones;
	}

	@PostConstruct
	public void init() {
		detalleTransacciones = repository.findAll();
	}
}