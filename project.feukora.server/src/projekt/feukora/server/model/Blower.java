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
	private Blowertype fi_blowertypeid;
	@ManyToOne
	private Fuel fi_fuelid;
	private String name;
	
	/**
	 * Default constructor
	 */
	public Blower(){
		
	}
	 /**
	  * Blower constructor
	  * 
	  * @param fi_blowertypeid
	  * @param fi_fuelid
	  * @param name
	  */
	public Blower(Blowertype fi_blowertypeid, Fuel fi_fuelid, String name){
		this.fi_blowertypeid = fi_blowertypeid;
		this.fi_fuelid = fi_fuelid;
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
}
