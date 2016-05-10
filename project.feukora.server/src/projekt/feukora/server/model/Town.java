package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name = "Town.findByTownzip", query = "SELECT t FROM Town t WHERE t.zip=:zip"),
	@NamedQuery(name = "Town.findByName", query = "SELECT t FROM Town t WHERE t.name=:name"),
	@NamedQuery(name = "Town.findByCanton", query = "SELECT t FROM Town t WHERE t.canton=:canton"),
	@NamedQuery(name = "Town.findByMunicipality", query = "SELECT t FROM Town t WHERE t.municipality=:municipality"),
	
})

/**
 * This class describes a town.
 * @author Robin
 * @version 1.0
 */
public class Town implements Serializable {

	
	
	private int zip;
	private String name;
	private String canton;
	private int municipality;
	
	
	/**
	 * This ist the standard constructor
	 */
	public Town(){
		
	}
	
	/**
	 * This constructor refers to the attributes of the town class
	 * @param name
	 * @param canton
	 * @param municipality
	 */
	
	public Town (String name, String canton, int municipality){
	this.name = name;
	this.canton = canton;
	this.municipality = municipality;
	
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
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

	public int getMunicipality() {
		return municipality;
	}

	public void setMunicipality(int municipality) {
		this.municipality = municipality;
	}
	
	
	
}
