package projekt.feukora.server.business;

import java.util.GregorianCalendar;
import java.util.List;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.persister.AppointmentPersister;
import projekt.feukora.server.persister.AppointmentPersisterImpl;

/**
 * This Class implements the methods of the interface AppointmentManager.
 * 
 * @author Allan
 * @version 1.0
 *
 */
public class AppointmentManagerImpl implements AppointmentManager{
	
	private AppointmentPersister appointmentPersister = new AppointmentPersisterImpl();

	@Override
	public void saveAppointment(Appointment entity) throws Exception {
			appointmentPersister.saveAppointment(entity);
	}

	@Override
	public Appointment updateAppointment(Appointment entity) throws Exception {
		return appointmentPersister.updateAppointment(entity);
	}

	@Override
	public void deleteAppointment(Appointment entity) throws Exception {
		appointmentPersister.deleteAppointment(entity);	
	}

	@Override
	public void deleteAppointmentByAppointmentid(Integer appointmentid) throws Exception {
		appointmentPersister.deleteAppointmentByAppointmentid(appointmentid);
	}

	@Override
	public Appointment findAppointmentByAppointmentid(Integer appointmentid) {
		return appointmentPersister.findAppointmentByAppointmentid(appointmentid);
	}

	@Override
	public List<Appointment> findAllAppointments() {
		return appointmentPersister.findAllAppointments();
	}

	@Override
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate) {
		return appointmentPersister.findAppointmentByAppointmentdate(appointmentdate);
	}
}
