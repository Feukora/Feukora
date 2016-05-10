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
	@NamedQuery(name = "Rapport.findByTransgression_smokenumber", query = "SELECT r FROM Rapport r WHERE r.transgression_smokenumber=:transgression_smokenumber"),
	@NamedQuery(name = "Rapport.findByTransgression_oilpart", query = "SELECT r FROM Rapport r WHERE r.transgression_oilpart=:transgression_oilpart"),
	@NamedQuery(name = "Rapport.findByExhaustgaslost", query = "SELECT r FROM Rapport r WHERE r.exhaustgaslost=:exhaustgaslost"),
	@NamedQuery(name = "Rapport.findByNitrogendioxide", query = "SELECT r FROM Rapport r WHERE r.nitrogendioxide=:nitrogendioxide"),
	@NamedQuery(name = "Rapport.findByCarbonmonoxide", query = "SELECT r FROM Rapport r WHERE r.carbonmonoxide=:carbonmonoxide"),
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
	
	
	/**
	 * 
	 * Rapport Constructor
	 * 
	 * @param rapportid
	 * @param fi_controltypeid
	 * @param fi_customerheaterid
	 * @param fi_userid
	 * @param fi_appointmentid
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
	public Rapport(int rapportid, Controltype fi_controltypeid, Customerheater fi_customerheaterid, Users fi_userid, Appointment fi_appointmentid, GregorianCalendar measuringdate, Boolean results, Boolean additionalsteps, String comments, Boolean transgression_smokenumber, Boolean transgression_oilpart, Boolean exhaustgaslost, Boolean nitrogendioxide, Boolean carbonmonoxide){
		this.rapportid = rapportid;
		this.fi_controltypeid = fi_controltypeid;
		this.fi_customerheaterid = fi_customerheaterid;
		this.fi_userid = fi_userid;
		this.fi_appointmentid = fi_appointmentid;
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


	public void setRapportid(int rapportid) {
		this.rapportid = rapportid;
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
	
	

}
