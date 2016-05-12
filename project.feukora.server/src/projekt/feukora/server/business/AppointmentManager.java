package projekt.feukora.server.business;

import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Customer;

/**
 * Interface to handle appointments entities
 * 
 * @author Allan
 * @version 1.0
 *
 */
public interface AppointmentManager {
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
	 * @return
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
	 * Delete the appointment entity with this id
	 * 
	 * @param appointmentid
	 * @throws Exception
	 */
	void deleteAppointmentByAppointmentid(Integer appointmentid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param appointmentid
	 * @return
	 */
	Appointment findAppointmentByAppointmentid(Integer appointmentid);

	/**
	 * Return all entities
	 * 
	 * @return
	 */
	List<Appointment> findAllAppointments();

	/**
	 * Return a list with appointments with this appointmentdate
	 * 
	 * @param appointmentdate
	 * @return
	 */
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate);

}
