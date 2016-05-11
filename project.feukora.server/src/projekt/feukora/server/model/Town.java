package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a town.
 * 
 * @version 1.2
 * @author Robin
 * 
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Town.findByTownzip", query = "SELECT t FROM Town t WHERE t.zip=:zip"),
	@NamedQuery(name = "Town.findByName", query = "SELECT t FROM Town t WHERE t.name=:name"),
	@NamedQuery(name = "Town.findByCanton", query = "SELECT t FROM Town t WHERE t.canton=:canton")
})
public class Town implements Serializable {

	@Id
	private int zip;
	private String name;
	private String canton;
	
	/**
	 * Default constructor
	 */
	public Town(){
		
	}
	
	/**
	 * Town constructor
	 * 
	 * @param name
	 * @param canton
	 */
	
	public Town (String name, String canton){
	this.name = name;
	this.canton = canton;
	
	}

	public int getZip() {
		return zip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}	
}
