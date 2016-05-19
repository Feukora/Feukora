package projekt.feukora.server.business;

import java.util.List;

import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.persister.ControltypePersister;
import projekt.feukora.server.persister.ControltypePersisterImpl;

public class ControltypeManagerImpl implements ControltypeManager{
	
	ControltypePersister controltypePersister = new ControltypePersisterImpl();

	@Override
	public void saveControltype(Controltype entity) throws Exception {
		if((Integer)entity.getControltypeid()== null){
			controltypePersister.saveControltype(entity);
		}else{
			throw new Exception ("Die Controltype(id =" + entity.getControltypeid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Controltype updateControltype(Controltype entity) throws Exception {
		return controltypePersister.updateControltype(entity);
	}

	@Override
	public void deleteControltype(Controltype entity) throws Exception {
		controltypePersister.deleteControltype(entity);
		
	}

	@Override
	public void deleteControltypeByControltypeid(Integer controltypeid) throws Exception {
		controltypePersister.deleteControltypeByControltypeid(controltypeid);
		
	}

	@Override
	public Controltype findControltypeByControltypeid(Integer controltypeid) {
		return controltypePersister.findControltypeByControltypeid(controltypeid);
	}

	@Override
	public List<Controltype> findAllControltype() {
		return controltypePersister.findAllControltypes();
	}

	@Override
	public Controltype findControltypeByName(String name) {
		return controltypePersister.findControltypeByName(name);
	}

}
