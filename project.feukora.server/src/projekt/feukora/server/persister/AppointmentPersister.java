package projekt.feukora.server.persister;

import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Appointment;

/**
 * This interface refers to a AppointmentPersister
 * 
 * @version 1.1
 * @author Allan
 *
 */

public interface AppointmentPersister {
	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void saveAppointment(Appointment entity) throws Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return Appointment
	 * @throws Exception
	 */
	Appointment updateAppointment(Appointment entity) throws Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 */
	void deleteAppointment(Appointment entity) throws Exception;

	/**
	 * Delete the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteAppointmentByAppointmentid(Integer appointmentid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return Appointment
	 */
	Appointment findAppointmentByAppointmentid(Integer appointmentid);

	/**
	 * Return all entities
	 * 
	 * @return List with Appointments
	 */
	List<Appointment> findAllAppointments();

	/**
	 * Return a list with Appointments with this Date
	 * 
	 * @param vorname
	 * @return List with Appointments
	 */
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate);
}

