package projekt.feukora.server.business;

import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.persister.RapportPersister;
import projekt.feukora.server.persister.RapportPersisterImpl;

/**
 * This Class implements the methods of the interface RapportManager
 * 
 * @author Sandro
 * @version 1.1
 */

public class RapportManagerImpl implements RapportManager {
	
	private RapportPersister rapportPersister = new RapportPersisterImpl();

	@Override
	public void saveRapport(Rapport entity) throws Exception {
		if((Integer) entity.getRapportid() == null){
			rapportPersister.saveRapport(entity);;
		}else{
			throw new Exception("Der Rapport (id = "+ entity.getRapportid() + ") ist bereits vorhanden");
		}
		
	}

	@Override
	public Rapport updateRapport(Rapport entity) throws Exception {
		return rapportPersister.updateRapport(entity);
	}

	@Override
	public void deleteRapport(Rapport entity) throws Exception {
		rapportPersister.deleteRapport(entity);
		
	}

	@Override
	public void deleteRapportByRapportid(Integer rapportid) throws Exception {
		rapportPersister.deleteRapportByRapportid(rapportid);
		
	}

	@Override
	public Rapport findRapportByRapportid(Integer rapportid) {
		return rapportPersister.findRapportByRapportid(rapportid);
	}

	@Override
	public List<Rapport> findAllRapports() {
		return rapportPersister.findAllRapports();
	}

	@Override
	public List<Rapport> findRapportByResults(Boolean results) {
		return rapportPersister.findRapportByResults(results);
	}

	@Override
	public List<Rapport> findRapportByMeasuringdate(GregorianCalendar measuringdate) {
		return rapportPersister.findRapportByMeasuringdate(measuringdate);
	}
}