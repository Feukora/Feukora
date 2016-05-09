package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery(name = "Customerheater.findByCustomerheaterid", query = "SELECT ch FROM Customerheater ch WHERE ch.customerheaterid=:customerheaterid")})
public class Customerheater implements Serializable{
	
	@Id
	@GeneratedValue
	private int customerheaterid;
	@ManyToOne
	private Customer fi_customerid;
	@ManyToOne
	private Heater fi_heaterid;
	@ManyToOne
	private Blower fi_blowerid;
	@ManyToOne
	private Facilitymanager fi_facilitymanagerid;
	private int bloweryear;
	private int heateryear;
	private int performance;
	
	public Customerheater() {
		
	}
	
	public Customerheater(int customerheaterid, Customer fi_customerid, Heater fi_heaterid, Blower fi_blowerid, Facilitymanager fi_facilitymanagerid, int bloweryear, int heateryear, int performance) {
		this.customerheaterid = customerheaterid;
		this.fi_customerid = fi_customerid;
		this.fi_heaterid = fi_heaterid;
		this.fi_blowerid = fi_blowerid;
		this.fi_facilitymanagerid = fi_facilitymanagerid;
		this.bloweryear = bloweryear;
		this.heateryear = heateryear;
		this.performance = performance;
	}
	
	
	public int getCustomerheaterid() {
		return customerheaterid;
	}
	public void setCustomerheaterid(int customerheaterid) {
		this.customerheaterid = customerheaterid;
	}
	public int getBloweryear() {
		return bloweryear;
	}
	public void setBloweryear(int bloweryear) {
		this.bloweryear = bloweryear;
	}
	public int getHeateryear() {
		return heateryear;
	}
	public void setHeateryear(int heateryear) {
		this.heateryear = heateryear;
	}
	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}

	
}
