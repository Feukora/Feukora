package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Deficit;

public class DeficitPersisterImpl implements DeficitPersister {

	@Override
	public void saveDeficit(Deficit entity) throws Exception {
		new GenericPersisterImpl<Deficit>(Deficit.class).save(entity);
		
	}

	@Override
	public Deficit updateDeficit(Deficit entity) throws Exception {
		return new GenericPersisterImpl<Deficit>(Deficit.class).update(entity);
	}

	@Override
	public void deleteDeficit(Deficit entity) throws Exception {
		new GenericPersisterImpl<Deficit>(Deficit.class).delete(entity);
		
	}

	@Override
	public void deleteDeficitByDeficitid(Integer Deficitid) throws Exception {
		new GenericPersisterImpl<Deficit>(Deficit.class).deleteById(Deficitid);
		
	}

	@Override
	public Deficit findDeficitByDeficitid(Integer Deficitid) {
		return new GenericPersisterImpl<Deficit>(Deficit.class).findById(Deficitid);
	}

	@Override
	public List<Deficit> findAllDeficits() {
		return new GenericPersisterImpl<Deficit>(Deficit.class).findAll();
	}

}
