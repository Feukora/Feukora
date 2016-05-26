package projekt.feukora.server.persister;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

/**
 * This interface refers to a AppointmentPersister
 * 
 * @version 1.5
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
	 * Return a list with appointments with this appointmentdate
	 * 
	 * @param appointmentdate
	 * @return
	 */
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate);

	
	List<Appointment> findAppointmentsForInspector( User inspector );
}
