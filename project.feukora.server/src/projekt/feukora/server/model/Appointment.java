package projekt.feukora.server.model;

import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * This class refers to a appointment
 * 
 * @version
 * @author Allan
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Appointment.findByAppointmentid", query = "SELECT a FROM Customer a WHERE a.appointmentid=:appointmentid"),
	@NamedQuery(name = "Appointment.findByAppointmentdate", query = "SELECT a FROM Customer a WHERE a.appointmentdate=:appointmentdate"),
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
	 * standard constructor
	 */
	public Appointment(){
	}
	
	/**
	 * constructor 
	 * @param appointmentid
	 * @param fi_costumerheaterid
	 * @param fi_userid
	 * @param fi_createdby
	 * @param created
	 * @param appointmentdate
	 * @param comments
	 */
	public Appointment(int appointmentid, Customerheater fi_costumerheaterid, User fi_userid, Rapport fi_createdby, GregorianCalendar created,
			GregorianCalendar appointmentdate, String comments){
		this.appointmentdate = appointmentdate;
		this.appointmentid = appointmentid;
		this.comments = comments;
		this.created = created;
		this.fi_costumerheaterid = fi_costumerheaterid;
		this.fi_createdby = fi_createdby;
		this.fi_userid = fi_userid;
	}

	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
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

