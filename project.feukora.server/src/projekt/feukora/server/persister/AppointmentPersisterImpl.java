package projekt.feukora.server.persister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Controltype;
import projekt.feukora.server.model.Customer;

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
	public void deleteAppointmentByAppointment(Integer appointmentid) throws Exception {
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
	public List<Appointment> findAppointmentByAppointmentid(String appointmentid) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Appointment> tQuery = em.createNamedQuery("Appointment.findByLastname",
				Appointment.class);

		tQuery.setParameter("appointmentid", appointmentid);

		List<Appointment> appointmentidlist = tQuery.getResultList();

		em.close();

		return appointmentidlist != null ? appointmentidlist : new ArrayList<Appointment>();
	}

	@Override
	public List<Appointment> findAppointmentByAppointmentdate(String appointmentdate) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Appointment> tQuery = em.createNamedQuery("Appointment.findByLastname",
				Appointment.class);

		tQuery.setParameter("appointmentdate", appointmentdate);

		List<Appointment> appointmentdatelist = tQuery.getResultList();

		em.close();

		return appointmentdatelist != null ? appointmentdatelist : new ArrayList<Appointment>();
	}

}
