package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.persister.HeaterPersister;
import projekt.feukora.server.persister.HeaterPersisterImpl;

/**
 * This Class implements the methods of the interface HeaterManager.
 * 
 * @author Patrick
 * @version 1.1
 */

public class HeaterManagerImpl implements HeaterManager {
	
	private HeaterPersister heaterPersister = new HeaterPersisterImpl();

	@Override
	public void saveHeater(Heater entity) throws Exception {
//		if((Integer) entity.getHeaterid() == null){
			heaterPersister.saveHeater(entity);
//		}else{
//			throw new Exception("Der Heater (id = "+ entity.getHeaterid() + ") ist bereits vorhanden");
//		}
		
	}

	@Override
	public Heater updateHeater(Heater entity) throws Exception {
		return heaterPersister.updateHeater(entity);
		
	}

	@Override
	public void deleteHeater(Heater entity) throws Exception {
		heaterPersister.deleteHeater(entity);
		
	}

	@Override
	public void deleteHeaterByHeaterid(Integer heaterid) throws Exception {
		heaterPersister.deleteHeaterByHeaterid(heaterid);
		
	}

	@Override
	public Heater findHeaterByHeaterid(Integer heaterid) {
		return heaterPersister.findHeaterByHeaterid(heaterid);
	}

	@Override
	public List<Heater> findAllHeaters() {
		return heaterPersister.findAllHeaters();
	}

	@Override
	public List<Heater> findHeaterByName(String name) {
		return heaterPersister.findHeaterByName(name);
	}

}
