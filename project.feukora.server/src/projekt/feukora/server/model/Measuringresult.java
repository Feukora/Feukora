package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a measuringresult.
 * 
 * @version 1.1
 * @author Patrick
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Measuringresult.findByMeasuringresultid", query = "SELECT mr FROM Measuringresult mr WHERE mr.measuringresultid=:measuringid"),
})

public class Measuringresult implements Serializable{
	
	@Id
	@GeneratedValue
	private int measuringresultid;
	@ManyToOne
	private int fi_rapportid;
	private int position;
	private int measuringgrade;
	private int smokenumber;
	private int carbonmonoxide;
	private boolean oilpart;
	private int nitrogendioxide;
	private int exhaustgastemp;
	private int heatertemp;
	private int blowertemp;
	private double oxygen;
	private double exhaustgasloss;
	
	/**
	 * Defaul constructor
	 */
	public Measuringresult(){
		
	}
	
	/**
	 * Measuringresult constructor
	 * @param position
	 * @param measuringgrade
	 * @param smokenumber
	 * @param carbonmonoxide
	 * @param oilpart
	 * @param nitrogendioxide
	 * @param exhaustgastemp
	 * @param heatertemp
	 * @param blowertemp
	 * @param oxygen
	 * @param exhaustgasloss
	 */
	public Measuringresult(int position, int measuringgrade, int smokenumber, int carbonmonoxide, boolean oilpart, int nitrogendioxide, int exhaustgastemp, int heatertemp, int blowertemp, double oxygen, double exhaustgasloss){
		this.position = position;
		this.measuringgrade = measuringgrade;
		this.smokenumber = smokenumber;
		this.carbonmonoxide = carbonmonoxide;
		this.oilpart = oilpart;
		this.nitrogendioxide = nitrogendioxide;
		this.exhaustgastemp = exhaustgastemp;
		this.heatertemp = heatertemp;
		this.blowertemp = blowertemp;
		this.oxygen = oxygen;
		this.exhaustgasloss = exhaustgasloss;
	}

	public int getMeasuringresultid() {
		return measuringresultid;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getMeasuringgrade() {
		return measuringgrade;
	}

	public void setMeasuringgrade(int measuringgrade) {
		this.measuringgrade = measuringgrade;
	}

	public int getSmokenumber() {
		return smokenumber;
	}

	public void setSmokenumber(int smokenumber) {
		this.smokenumber = smokenumber;
	}

	public int getCarbonmonoxide() {
		return carbonmonoxide;
	}

	public void setCarbonmonoxide(int carbonmonoxide) {
		this.carbonmonoxide = carbonmonoxide;
	}

	public boolean isOilpart() {
		return oilpart;
	}

	public void setOilpart(boolean oilpart) {
		this.oilpart = oilpart;
	}

	public int getNitrogendioxide() {
		return nitrogendioxide;
	}

	public void setNitrogendioxide(int nitrogendioxide) {
		this.nitrogendioxide = nitrogendioxide;
	}

	public int getExhaustgastemp() {
		return exhaustgastemp;
	}

	public void setExhaustgastemp(int exhaustgastemp) {
		this.exhaustgastemp = exhaustgastemp;
	}

	public int getHeatertemp() {
		return heatertemp;
	}

	public void setHeatertemp(int heatertemp) {
		this.heatertemp = heatertemp;
	}

	public int getBlowertemp() {
		return blowertemp;
	}

	public void setBlowertemp(int blowertemp) {
		this.blowertemp = blowertemp;
	}

	public double getOxygen() {
		return oxygen;
	}

	public void setOxygen(double oxygen) {
		this.oxygen = oxygen;
	}

	public double getExhaustgasloss() {
		return exhaustgasloss;
	}

	public void setExhaustgasloss(double exhaustgasloss) {
		this.exhaustgasloss = exhaustgasloss;
	}
}
