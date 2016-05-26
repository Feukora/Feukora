package projekt.feukora.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

/**
 * RMI interface for handling appointment entities
 * 
 * @author Allan 
 * @version 1.1
 */
public interface AppointmentRMI extends Remote {

	/**
	 * Save the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void saveAppointment(Appointment entity) throws RemoteException, Exception;

	/**
	 * Update the given entity
	 * 
	 * @param entity
	 * @return entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	Appointment updateAppointment(Appointment entity) throws RemoteException, Exception;

	/**
	 * Delete the given entity
	 * 
	 * @param entity
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteAppointment(Appointment entity) throws RemoteException, Exception;

	/**
	 * Save the entity with this id
	 * 
	 * @param id
	 * @throws Exception
	 * @throws RemoteException
	 */
	void deleteAppointmentByAppointmentid(Integer appointmentid) throws RemoteException, Exception;

	/**
	 * Return the entity with this id
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException 
	 */
	Appointment findAppointmentByAppointmentid(Integer appointmentid) throws RemoteException;

	/**
	 * Return all entities
	 * 
	 * @return
	 * @throws RemoteException 
	 */
	List<Appointment> findAllAppointments() throws RemoteException;

	/**
	 * Return a list with appointments with this appointmentdate
	 * 
	 * @param name
	 * @return
	 * @throws RemoteException 
	 */
	List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate) throws RemoteException;

	/**
	 * Return a list with appointments for this inspector
	 * @param inspector
	 * @return
	 * @throws RemoteException
	 */
	List<Appointment> findAppointmentsForInspector( User inspector ) throws RemoteException;	
}
