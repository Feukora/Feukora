package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a controltype
 * 
 * @version 1.0
 * @author Allan
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Controltype.findByControltypeid", query = "SELECT ct FROM Controltype ct WHERE ct.controltypeid=:controltypeid"),
	@NamedQuery(name = "Controltype.findByname", query = "SELECT ct FROM Controltype ct WHERE ct.name=:name"),
})

public class Controltype implements Serializable {

	@Id
	@GeneratedValue
	private int controltypeid;
	private String name;
	
	public Controltype(){
	}
	
	public Controltype(int controltypeid, String name){
		this.controltypeid = controltypeid;
		this.name = name;
	}

	public int getControltypeid() {
		return controltypeid;
	}

	public void setControltypeid(int controltypeid) {
		this.controltypeid = controltypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
