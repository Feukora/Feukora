package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Measuringresult;

public class MeasuringresultPersisterImpl implements MeasuringresultPersister {

	@Override
	public void saveMeasuringresult(Measuringresult entity) throws Exception {
		new GenericPersisterImpl<Measuringresult>(Measuringresult.class).save(entity);
		
	}

	@Override
	public Measuringresult updateMeasuringresult(Measuringresult entity) throws Exception {
		return new GenericPersisterImpl<Measuringresult>(Measuringresult.class).update(entity);
	}

	@Override
	public void deleteMeasuringresult(Measuringresult entity) throws Exception {
		new GenericPersisterImpl<Measuringresult>(Measuringresult.class).delete(entity);
		
	}

	@Override
	public void deleteMeasuringresultByMeasuringresultid(Integer measuringresultid) throws Exception {
		new GenericPersisterImpl<Measuringresult>(Measuringresult.class).deleteById(measuringresultid);
		
	}

	@Override
	public Measuringresult findMeasuringresultByMeasuringresultid(Integer measuringresultid) {
		return new GenericPersisterImpl<Measuringresult>(Measuringresult.class).findById(measuringresultid);
	}

	@Override
	public List<Measuringresult> findAllMeasuringresult() {
		return new GenericPersisterImpl<Measuringresult>(Measuringresult.class).findAll();
	}


}
