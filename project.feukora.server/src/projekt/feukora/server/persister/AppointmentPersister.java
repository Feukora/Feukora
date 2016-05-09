package projekt.feukora.server.persister;

import java.util.List;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.Customer;

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
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 */
	void deleteAppointmentByAppointment(Integer appointmentid) throws Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
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
	 * Return a list with cusomerts with this lastname
	 * 
	 * @param name
	 * @return
	 */
	public List<Appointment> findAppointmentByAppointmentid(String lastname);

	/**
	 * Return a list with cusomerts with this firstname
	 * 
	 * @param vorname
	 * @return
	 */
	public List<Appointment> findAppointmentByAppointmentdate(String firstname);
	
}

