package projekt.feukora.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a fuel.
 * @author Tamara
 * @version 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Fuel.findByFuelid", query = "SELECT f FROM Fuel f WHERE f.fuelid=:fuelid"),
	@NamedQuery(name = "Fuel.findByName", query = "SELECT f FROM Fuel f WHERE f.name=:name") })
public class Fuel {
	
	@Id
	@GeneratedValue
	private int fuelid;
	private String name;
	
	/**
	 * default constructor
	 */
	public Fuel(){
		
	}
	
	/**
	 * constructor for the class Fuel
	 * @param fuelid
	 * @param name
	 */
	public Fuel(int fuelid, String name){
		this.fuelid = fuelid;
		this.name = name;
	}

	public int getFuelid() {
		return fuelid;
	}

	public void setFuelid(int fuelid) {
		this.fuelid = fuelid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
