package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @version 1.0
 * @author Allan
 *
 */

// dadurch kommmt es in die DB // embeddable wenn die id als Fremdschlüssel woanders genutzt wird
@Embeddable


// implements dazuschreiben
public class Customerfunction implements Serializable {

// Alle Attribute reinholen private und gleich schreiben wie im ERD
	@Id // immer schreiben vor den attribute
	@GeneratedValue // immer schreiben vor den attribute
	private int customerfunctionid;
	private String name;
	
	// leeren Konstruktor machen
	public Customerfunction(){
	}
	
	/**
	 * 
	 * @param customerfunctionid
	 * @param name
	 */ // konstruktor mit allen Attributen
	public Customerfunction(int customerfunctionid, String name){
		this.customerfunctionid = customerfunctionid;
		this.name = name;
	}
	
	
	public int getCustomerfunctionid() {
		return customerfunctionid;
	}
	public void setCustomerfunctionid(int customerfunctionid) {
		this.customerfunctionid = customerfunctionid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
