package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Blower.findByBlowerid", query = "SELECT b FROM Blower b WHERE b.blowerid=:blowerid"),
	@NamedQuery(name = "Blower.findByName", query = "SELECT b FROM Blower b WHERE b.name=:name"),
})

/**
 * This class refers to a blower.
 * 
 * @version 1.1
 * @author Robin
 * 
 */
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
	
	public String getName() {
		return name;
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
}
