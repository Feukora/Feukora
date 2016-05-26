package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a blowertype.
 * 
 * @version 1.4
 * @author Patrick
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Blowertype.findByBlowertypeid", query = "SELECT bt FROM Blowertype bt WHERE bt.blowertypeid=:blowertypeid"),
	@NamedQuery(name = "Blowertype.findByName", query = "SELECT bt FROM Blowertype bt WHERE bt.name=:name"),
	})

public class Blowertype implements Serializable {
	
	@Id
	@GeneratedValue
	private int blowertypeid;
	private String name;
	
	/**
	 *Default constructor
	 */
	public Blowertype(){
		
	}
	
	/**
	 * Blowertype constructor
	 * 
	 * @param name
	 */
	public Blowertype(String name){
		this.name = name;
	}

	public int getBlowertypeid() {
		return blowertypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}