package projekt.feukora.server.model;


import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Customerheater costumerheaterid;
	@ManyToOne
	private Users user;
	@ManyToOne
	private Users createdby;
	@Temporal (TemporalType.TIMESTAMP)
	private GregorianCalendar created;
	@Temporal (TemporalType.TIMESTAMP)
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
	 * @param costumerheaterid
	 * @param user
	 * @param createdby
	 * @param created
	 * @param appointmentdate
	 * @param comments
	 */
	public Appointment(Customerheater costumerheaterid, Users user, Users createdby, GregorianCalendar created,
			GregorianCalendar appointmentdate, String comments){
		this.appointmentdate = appointmentdate;
		this.comments = comments;
		this.created = created;
		this.costumerheaterid = costumerheaterid;
		this.createdby = createdby;
		this.user = user;
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