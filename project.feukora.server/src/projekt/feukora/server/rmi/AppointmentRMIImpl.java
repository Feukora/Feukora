package projekt.feukora.server.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

import projekt.feukora.server.business.AppointmentManager;
import projekt.feukora.server.business.AppointmentManagerImpl;
import projekt.feukora.server.model.Appointment;
import projekt.feukora.server.model.User;

/**
 * This Class implements the methods of the interface AppointmentRMI
 *  
 * @author Allan
 * @version 1.0
 */
public class AppointmentRMIImpl extends UnicastRemoteObject implements AppointmentRMI {

	
	private static final long serialVersionUID = -1675223100958250005L;
	/**
	 * 
	 */
	private AppointmentManager appointmentManager;

	public AppointmentRMIImpl() throws RemoteException {
		appointmentManager = new AppointmentManagerImpl();
	}
	
	/**
	 * 
	 */
	@Override
	public void saveAppointment(Appointment entity) throws RemoteException, Exception {
		appointmentManager.saveAppointment(entity);	
	}

	@Override
	public Appointment updateAppointment(Appointment entity) throws RemoteException, Exception {
		return appointmentManager.updateAppointment(entity);
	}

	@Override
	public void deleteAppointment(Appointment entity) throws RemoteException, Exception {
		appointmentManager.deleteAppointment(entity);
	}

	@Override
	public void deleteAppointmentByAppointmentid(Integer appointmentid) throws RemoteException, Exception {
		appointmentManager.deleteAppointmentByAppointmentid(appointmentid);	
	}

	@Override
	public Appointment findAppointmentByAppointmentid(Integer appointmentid) throws RemoteException {
		return appointmentManager.findAppointmentByAppointmentid(appointmentid);
	}

	@Override
	public List<Appointment> findAllAppointments() throws RemoteException {
		return appointmentManager.findAllAppointments();
	}

	@Override
	public List<Appointment> findAppointmentByAppointmentdate(GregorianCalendar appointmentdate) throws RemoteException {
		return appointmentManager.findAppointmentByAppointmentdate(appointmentdate);
	}

	@Override
	public List<Appointment> findAppointmentsForInspector(User inspector) {
		return appointmentManager.findAppointmentsForInspector(inspector);
	}
}
