package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.persister.BlowerPersister;
import projekt.feukora.server.persister.BlowerPersisterImpl;

/**
 * This Class implements the methods of the interface BlowerManager.
 * 
 * @author Robin
 * @version 1.1
 */
public class BlowerManagerImpl implements BlowerManager {
	private BlowerPersister blowerPersister = new BlowerPersisterImpl();

	@Override
	public void saveBlower(Blower entity) throws Exception {
		if((Integer) entity.getBlowerid() == null){
			blowerPersister.saveBlower(entity);
		}else{
			throw new Exception("Der Brenner (id = "+ entity.getBlowerid() + ") ist bereits vorhanden");
		}
	}

	@Override
	public Blower updateBlower(Blower entity) throws Exception {
		return blowerPersister.updateBlower(entity);
	}

	@Override
	public void deleteBlower(Blower entity) throws Exception {
		blowerPersister.deleteBlower(entity);
		
	}

	@Override
	public void deleteBlowerByBlowerid(Integer blowerid) throws Exception {
		blowerPersister.deleteBlowerByBlowerid(blowerid);
		
	}

	@Override
	public Blower findBlowerByBlowerid(Integer blowerid) {
		return blowerPersister.findByBlowerid(blowerid);
	}

	@Override
	public List<Blower> findAllBlowers() {
		return blowerPersister.findAllBlowers();
	}

	@Override
	public List<Blower> findBlowerByName(String name) {
		return blowerPersister.findBlowerByName(name);
	}

}
