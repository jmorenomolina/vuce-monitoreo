package pe.gob.vuce.monitoreo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.gob.vuce.monitoreo.entity.Transaccion;
import pe.gob.vuce.monitoreo.repository.TransaccionRepository;

@Component
public class TransaccionComponent {
	
    private final TransaccionRepository transaccionRepository;
    
    @Autowired
    public TransaccionComponent(TransaccionRepository transaccionRepository) {
    	super();  
    	this.transaccionRepository = transaccionRepository;
    }
    
    public void registrarTransaccion(Transaccion transaccion) {
    	transaccionRepository.save(transaccion);
    }

}
