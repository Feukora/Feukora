package projekt.feukora.server.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to an appointment
 * 
 * @version 1.1
 * @author Allan
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Appointment.findByAppointmentid", query = "SELECT a FROM Appointment a WHERE a.appointmentid=:appointmentid"),
	@NamedQuery(name = "Appointment.findByAppointmentdate", query = "SELECT a FROM Appointment a WHERE a.appointmentdate=:appointmentdate")
 })

public class Appointment {

	@Id
	@GeneratedValue
	private int appointmentid;
	@ManyToOne
	private Customerheater fi_costumerheaterid;
	@ManyToOne
	private Users fi_userid;
	@ManyToOne
	private Users fi_createdby;
	private GregorianCalendar created;
	private GregorianCalendar appointmentdate;
	private String comments;
	
	/**
	 * Default constructor
	 */
	public Appointment(){
	}
	
	/**
	 * Appointment constructor 
	 * 
	 * @param fi_costumerheaterid
	 * @param fi_userid
	 * @param fi_createdby
	 * @param created
	 * @param appointmentdate
	 * @param comments
	 */
	public Appointment(Customerheater fi_costumerheaterid, Users fi_userid, Users fi_createdby, GregorianCalendar created,
			GregorianCalendar appointmentdate, String comments){
		this.appointmentdate = appointmentdate;
		this.comments = comments;
		this.created = created;
		this.fi_costumerheaterid = fi_costumerheaterid;
		this.fi_createdby = fi_createdby;
		this.fi_userid = fi_userid;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public GregorianCalendar getCreated() {
		return created;
	}

	public void setCreated(GregorianCalendar created) {
		this.created = created;
	}

	public GregorianCalendar getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(GregorianCalendar appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}	
}