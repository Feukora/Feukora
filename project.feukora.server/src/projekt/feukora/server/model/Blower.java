package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a blower.
 * 
 * @version 1.5
 * @author Robin
 * 
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Blower.findByBlowerid", query = "SELECT b FROM Blower b WHERE b.blowerid=:blowerid"),
	@NamedQuery(name = "Blower.findByName", query = "SELECT b FROM Blower b WHERE b.name=:name"),
})

public class Blower implements Serializable {

	@Id
	@GeneratedValue
	private int blowerid;
	@ManyToOne
	private Blowertype blowertypeid;
	@ManyToOne
	private Fuel fuelid;
	private String name;
	
	/**
	 * Default constructor
	 */
	public Blower(){
		
	}
	 /**
	  * Blower constructor
	  * 
	  * @param blowertypeid
	  * @param fuelid
	  * @param name
	  */
	public Blower(Blowertype blowertypeid, Fuel fuelid, String name){
		this.blowertypeid = blowertypeid;
		this.fuelid = fuelid;
		this.name = name;
		
	}
	public int getBlowerid() {
		return blowerid;
	}
	
	public void setBlowertypeid(Blowertype blowertypeid) {
		this.blowertypeid = blowertypeid;
	}
	public void setFuelid(Fuel fuelid) {
		this.fuelid = fuelid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBlowertype() {
		return blowertypeid.toString();
	}
	
	public String getFuel() {
		return fuelid.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public String toString()
	{
		return name;
	}
}