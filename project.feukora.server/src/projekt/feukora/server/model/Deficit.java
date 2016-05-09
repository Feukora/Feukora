package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Deficit.findByDeficitid", query = "SELECT d FROM Deficit d WHERE d.deficitid=:deficitid"),
	@NamedQuery(name = "Deficit.findByName", query = "SELECT d FROM Deficit d WHERE d.name=:name") })


public class Deficit implements Serializable {
	@Id
	@GeneratedValue 
	private int deficitid;
	private String name;
	
	//Empty constructor
	public Deficit(){
		
	}
	
	//Constructor with 
	public Deficit(int deficitid, String name){
		this.deficitid = deficitid;
		this.name = name;
	}
	
	
	//Getters and Setters
	public int getDeficitid() {
		return deficitid;
	}
	public void setDeficitid(int deficitid) {
		this.deficitid = deficitid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
