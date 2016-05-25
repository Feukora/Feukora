package projekt.feukora.server.business;

import java.util.List;
import projekt.feukora.server.model.Measuringresult;
import projekt.feukora.server.persister.MeasuringresultPersister;
import projekt.feukora.server.persister.MeasuringresultPersisterImpl;

/**
 * This Class implements the methods of the interface HeaterManager.
 * 
 * @author Patrick
 * @version 1.0
 */
public class MeasuringresultManagerImpl implements MeasuringresultManager {
	
	private MeasuringresultPersister measuringresultPersister = new MeasuringresultPersisterImpl();

	@Override
	public void saveMeasuringresult(Measuringresult entity) throws Exception {
			measuringresultPersister.saveMeasuringresult(entity);
	}

	@Override
	public Measuringresult updateMeasuringresult(Measuringresult entity) throws Exception {
		return measuringresultPersister.updateMeasuringresult(entity);
	}

	@Override
	public void deleteMeasuringresult(Measuringresult entity) throws Exception {
		measuringresultPersister.deleteMeasuringresult(entity);
	}

	@Override
	public void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws Exception {
		measuringresultPersister.deleteMeasuringresultByMeasuringresultid(measuringresultid);
	}

	@Override
	public Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid) {
		return measuringresultPersister.findMeasuringresultByMeasuringresultid(measuringresultid);
	}

	@Override
	public List<Measuringresult> findAllMeasuringresults() {
		return measuringresultPersister.findAllMeasuringresult();
	}
}
