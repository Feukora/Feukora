package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Blowertype;
import projekt.feukora.server.persister.BlowertypePersister;
import projekt.feukora.server.persister.BlowertypePersisterImpl;

/**
 * This Class implements the methods of the interface BlowertypeManager.
 * 
 * @author Patrick
 * @version 1.0
 */

public class BlowertypeManagerImpl implements BlowertypeManager {

	private BlowertypePersister blowertypePersister = new BlowertypePersisterImpl();
	
	@Override
	public void saveBlowertype(Blowertype entity) throws Exception {
		if((Integer) entity.getBlowertypeid() == null){
			blowertypePersister.saveBlowertype(entity);
		}else{
			throw new Exception("Der Brennertyp (id = "+ entity.getBlowertypeid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Blowertype updateBlowertype(Blowertype entity) throws Exception {
		return blowertypePersister.updateBlowertype(entity);
	}

	@Override
	public void deleteBlowertype(Blowertype entity) throws Exception {
		blowertypePersister.deleteBlowertype(entity);
		
	}

	@Override
	public void deleteBlowertypeByBlowertypeid(Integer blowertypeid) throws Exception {
		blowertypePersister.deleteBlowertypeByBlowertypeid(blowertypeid);
		
	}

	@Override
	public Blowertype findBlowertypeByBlowertypeid(Integer blowertypeid) {
		return blowertypePersister.findBlowertypeByBlowertypeid(blowertypeid);
	}

	@Override
	public List<Blowertype> findAllBlowertypes() {
		return blowertypePersister.findAllBlowertypes();
	}

	@Override
	public Blowertype findBlowertypeByName(String name) {
		return blowertypePersister.findBlowertypeByName(name);
	}

}
