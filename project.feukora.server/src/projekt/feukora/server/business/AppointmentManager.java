package projekt.feukora.server.business;

import java.util.GregorianCalendar;
import java.util.List;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

/**
 * Interface to handle appointment entities
 * 
 * @author Allan
 * @version 1.4
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
	 * Delete the appointment entity with this id
	 * 
	 * @param appointmentid
	 * @throws Exception
	 */
	void deleteAppointmentByAppointmentid(Integer appointmentid) throws Exception;

	/**
	 * Return the appointment entity with this id
	 * 
	 * @param appointmentid
	 * @return Appointment
	 */
	Appointment findAppointmentByAppointmentid(Integer appointmentid);

	/**
	 * Return all entities
	 * 
	 * @return Appointments
	 */
	List<Appointment> findAllAppointments();

	/**
	 * Return a list with appointments with this appointment date
	 * 
	 * @param appointmentdate
	 * @return List with appointments
	 */
	List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate);

	/**
	 * Return a list with appointments for this inspector
	 * @param inspector
	 * @return List with appointments
	 */
	List<Appointment> findAppointmentsForInspector( User inspector );
}
