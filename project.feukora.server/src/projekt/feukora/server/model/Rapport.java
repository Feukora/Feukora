package projekt.feukora.server.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Sandro Fasser
 * @version 1.0
 * 
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Rapport.findByRapportid", query = "SELECT r FROM Rapport r WHERE r.rapportid=:rapportid"),
	@NamedQuery(name = "Rapport.findByMeasuringdate", query = "SELECT r FROM Rapport r WHERE r.measuringdate=:measuringdate"),
	@NamedQuery(name = "Rapport.findByResults", query = "SELECT r FROM Rapport r WHERE r.results=:results"),
	@NamedQuery(name = "Rapport.findByAdditionalsteps", query = "SELECT r FROM Rapport r WHERE r.additionalsteps=:additionalsteps"),
	@NamedQuery(name = "Rapport.findByComments", query = "SELECT r FROM Rapport r WHERE r.comments=:comments"),})


public class Rapport implements Serializable {
	
	//Where to put in the ManyToMany deficitid 
	@Id
	@GeneratedValue 
	private int rapportid;
	@ManyToOne
	private Controltype fi_controltypeid;
	@ManyToOne
	private Customerheater fi_customerheaterid;
	@ManyToOne
	private Users fi_userid;
	@ManyToOne
	private Appointment fi_appointmentid;
	
	private GregorianCalendar measuringdate;
	private Boolean results;
	private Boolean additionalsteps;
	private String comments;
	
	
	public Rapport(){
		
	}
	
	
	public Rapport(){
		
	}

}
