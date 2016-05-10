package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a customerfunction
 * 
 * @version 1.1
 * @author Allan
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Customerfunction.Customerfunctionid", query = "SELECT cf FROM Customerfunction cf WHERE cf.customerfunctionid=:customerfunctionid"),
	@NamedQuery(name = "Customerfunction.findByName", query = "SELECT cf FROM Customer cf WHERE cf.lastname=:name")
})
public class Customerfunction implements Serializable {

	@Id
	@GeneratedValue
	private int customerfunctionid;
	private String name;
	
	/**
	 * Default constructor
	 * 
	 */
	public Customerfunction(){
	}
	
	/**
	 * Customerfunction constructor
	 * 
	 * @param name
	 */
	public Customerfunction(String name){
		this.name = name;
	}
	
	
	public int getCustomerfunctionid() {
		return customerfunctionid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
