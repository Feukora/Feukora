package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Blower.findByBlowerid", query = "SELECT b FROM Company b WHERE b.blowerid=:blowerid"),
	@NamedQuery(name = "Blower.findByName", query = "SELECT b FROM Company b WHERE b.name=:name"),
})

/**
 * This class describes a Blower
 * @author Robin
 * @version 1.0
 */
public class Blower implements Serializable {

	@Id
	@GeneratedValue
	private int blowerid;
	@Embedded
	@ManyToOne
	private Blowertype fi_blowertypeid;
	@Embedded
	@ManyToOne
	private Fuel fi_fuelid;
	private String name;
	
	/**
	 * This is the standard constructor
	 */
	public Blower(){
		
	}
	 /**
	  * This constructor refers to the attributes of the Blower class
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
	public void setBlowerid(int blowerid) {
		this.blowerid = blowerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
