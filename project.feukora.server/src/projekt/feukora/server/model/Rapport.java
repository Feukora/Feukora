package projekt.feukora.server.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class refers to a rapport
 * 
 * @version 1.1
 * @author Sandro 
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Rapport.findByRapportid", query = "SELECT r FROM Rapport r WHERE r.rapportid=:rapportid"),
	@NamedQuery(name = "Rapport.findByMeasuringdate", query = "SELECT r FROM Rapport r WHERE r.measuringdate=:measuringdate"),
	@NamedQuery(name = "Rapport.findByResults", query = "SELECT r FROM Rapport r WHERE r.results=:results"),
	})
public class Rapport implements Serializable {
	
	@Id
	@GeneratedValue 
	private int rapportid;
	@ManyToOne
	private Controltype controltypeid;
	@ManyToOne
	private Customerheater customerheaterid;
	@ManyToOne
	private User userid;
	@ManyToOne
	private Appointment appointmentid;
	@Temporal (TemporalType.TIMESTAMP)
	private GregorianCalendar measuringdate;
	private Boolean results;
	private Boolean additionalsteps;
	private String comments;
	private Boolean transgression_smokenumber;
	private Boolean transgression_oilpart;
	private Boolean exhaustgaslost;
	private Boolean nitrogendioxide;
	private Boolean carbonmonoxide;
	
	/**
	 * Default constructor
	 */
	public Rapport(){
		
	}
	
	public Rapport( User user )
	{
		userid = user;
		measuringdate = new GregorianCalendar();
	}
	
	/**
	 * 
	 * Rapport Constructor
	 * 
	 * @param controltypeid
	 * @param customerheaterid
	 * @param userid
	 * @param appointmentid
	 * @param measuringdate
	 * @param results
	 * @param additionalsteps
	 * @param comments
	 * @param transgression_smokenumber
	 * @param transgression_oilpart
	 * @param exhaustgaslost
	 * @param nitrogendioxide
	 * @param carbonmonoxide
	 */
	public Rapport(Controltype controltypeid, Customerheater customerheaterid, User userid, Appointment appointmentid, GregorianCalendar measuringdate, Boolean results, Boolean additionalsteps, String comments, Boolean transgression_smokenumber, Boolean transgression_oilpart, Boolean exhaustgaslost, Boolean nitrogendioxide, Boolean carbonmonoxide){
		this.controltypeid = controltypeid;
		this.customerheaterid = customerheaterid;
		this.userid = userid;
		this.appointmentid = appointmentid;
		this.measuringdate = measuringdate;
		this.results = results;
		this.additionalsteps = additionalsteps;
		this.comments = comments;
		this.transgression_smokenumber = transgression_smokenumber;
		this.transgression_oilpart = transgression_oilpart;
		this.exhaustgaslost = exhaustgaslost;
		this.nitrogendioxide = nitrogendioxide;
		this.carbonmonoxide = carbonmonoxide;	
	}

	public int getRapportid() {
		return rapportid;
	}

	public GregorianCalendar getMeasuringdate() {
		return measuringdate;
	}

	public void setMeasuringdate(GregorianCalendar measuringdate) {
		this.measuringdate = measuringdate;
	}

	public Boolean getResults() {
		return results;
	}

	public void setResults(Boolean results) {
		this.results = results;
	}

	public Boolean getAdditionalsteps() {
		return additionalsteps;
	}

	public void setAdditionalsteps(Boolean additionalsteps) {
		this.additionalsteps = additionalsteps;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getTransgression_smokenumber() {
		return transgression_smokenumber;
	}

	public void setTransgression_smokenumber(Boolean transgression_smokenumber) {
		this.transgression_smokenumber = transgression_smokenumber;
	}

	public Boolean getTransgression_oilpart() {
		return transgression_oilpart;
	}

	public void setTransgression_oilpart(Boolean transgression_oilpart) {
		this.transgression_oilpart = transgression_oilpart;
	}

	public Boolean getExhaustgaslost() {
		return exhaustgaslost;
	}

	public void setExhaustgaslost(Boolean exhaustgaslost) {
		this.exhaustgaslost = exhaustgaslost;
	}

	public Boolean getNitrogendioxide() {
		return nitrogendioxide;
	}

	public void setNitrogendioxide(Boolean nitrogendioxide) {
		this.nitrogendioxide = nitrogendioxide;
	}

	public Boolean getCarbonmonoxide() {
		return carbonmonoxide;
	}

	public void setCarbonmonoxide(Boolean carbonmonoxide) {
		this.carbonmonoxide = carbonmonoxide;
	}
	
	public String getDate() {
		return measuringdate.toString();
	}
	
	public String getControltype() {
		return controltypeid.toString();
	}
	
	public String getInspector() {
		return userid.toString();
	}
}
