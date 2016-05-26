package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a heater.
 * 
 * @version 1.6
 * @author Patrick
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Heater.findByHeaterid", query = "SELECT h FROM Heater h WHERE h.heaterid=:heaterid"),
	@NamedQuery(name = "Heater.findByName", query = "SELECT h FROM Heater h WHERE h.name=:name"),
	})

public class Heater implements Serializable{

	@Id
	@GeneratedValue
	private int heaterid;
	private String name;
	
	/**
	 * Default constructor
	 */
	public Heater(){
		
	}
	
	/**
	 * Heater constructor
	 * 
	 * @param name
	 */
	public Heater(String name){
		this.name = name;
	}

	public int getHeaterid() {
		return heaterid;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
}