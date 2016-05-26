package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a customerheater.
 * 
 * @Version 1.5
 * @author Pascal
 *
 */

@Entity
@NamedQueries ({
	@NamedQuery(name = "Customerheater.findByCustomerheaterid", query = "SELECT ch FROM Customerheater ch WHERE ch.customerheaterid=:customerheaterid"),
	@NamedQuery(name = "Customerheater.findByPerformance", query = "SELECT ch FROM Customerheater ch WHERE ch.performance=:performance"),
	@NamedQuery(name = "Customerheater.getByCustomerId", query = "SELECT ch FROM Customerheater ch WHERE ch.customerid=:customerid")
	})

public class Customerheater implements Serializable{
	
	@Id
	@GeneratedValue
	private int customerheaterid;
	@ManyToOne
	private Customer customerid;
	@ManyToOne
	private Heater heaterid;
	@ManyToOne
	private Blower blowerid;
	@ManyToOne
	private Facilitymanager facilitymanagerid;
	private int bloweryear;
	private int heateryear;
	private int performance;
	
	/**
	 * Default constructor
	 */
	public Customerheater() {	
	}
	
	/**
	 * Customerheater constructor
	 * 
	 * @param customerid
	 * @param heaterid
	 * @param blowerid
	 * @param facilitymanagerid
	 * @param bloweryear
	 * @param heateryear
	 * @param performance
	 */
	
	public Customerheater(Customer customerid, Heater heaterid, Blower blowerid, Facilitymanager facilitymanagerid, int bloweryear, int heateryear, int performance) {
		this.customerid = customerid;
		this.heaterid = heaterid;
		this.blowerid = blowerid;
		this.facilitymanagerid = facilitymanagerid;
		this.bloweryear = bloweryear;
		this.heateryear = heateryear;
		this.performance = performance;
	}
	
	public int getCustomerheaterid() {
		return customerheaterid;
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
	
	@Override
	public String toString () {
		return customerid.toString();
	}
}