package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

/**
 * This class implements the Interface AppointmentPersister
 * 
 * @version 1.5
 * @author Pascal
 *
 */
public class AppointmentPersisterImpl implements AppointmentPersister{

	@Override
	public void saveAppointment(Appointment entity) throws Exception {
		new GenericPersisterImpl<Appointment>(Appointment.class).save(entity);
	}

	@Override
	public Appointment updateAppointment(Appointment entity) throws Exception {
		return new GenericPersisterImpl<Appointment>(Appointment.class).update(entity);	
	}

	@Override
	public void deleteAppointment(Appointment entity) throws Exception {
		new GenericPersisterImpl<Appointment>(Appointment.class).delete(entity);	
	}

	@Override
	public void deleteAppointmentByAppointmentid (Integer appointmentid) throws Exception {
		new GenericPersisterImpl<Appointment>(Appointment.class).deleteById(appointmentid);
		
	}

	@Override
	public Appointment findAppointmentByAppointmentid(Integer appointmentid) {
		return new GenericPersisterImpl<Appointment>(Appointment.class).findById(appointmentid);
	}

	@Override
	public List<Appointment> findAllAppointments() {
		return new GenericPersisterImpl<Appointment>(Appointment.class).findAll();
	}

	@Override
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Appointment> tQuery = em.createNamedQuery("Appointment.findByAppointmentdate",
				Appointment.class);

		tQuery.setParameter("appointmentdate", appointmentdate);

		List<Appointment> appointmentdatelist = tQuery.getResultList();

		em.close();

		return appointmentdatelist != null ? appointmentdatelist : new ArrayList<Appointment>();
	}

	@Override
	public List<Appointment> findAppointmentsForInspector(User inspector) {
		EntityManager em = JpaUtil.createEntityManager();
		
		TypedQuery<Appointment> tQuery = em.createNamedQuery("Appointment.findByUserId", Appointment.class);
		tQuery.setParameter("userId", inspector);
		List<Appointment> appointmentList = tQuery.getResultList();
		em.close();
		
		return appointmentList != null ? appointmentList : new ArrayList<Appointment>();
	}
	
}