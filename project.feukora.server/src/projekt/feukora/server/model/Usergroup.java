package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a usergroup.
 * 
 * @version 1.1
 * @author Tamara
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Usergroup.findByUsergroupid", query = "SELECT ug FROM Usergroup ug WHERE ug.usergroupid=:usergroupid"),
		@NamedQuery(name = "Usergroup.findByName", query = "SELECT ug FROM Usergroup ug WHERE ug.name=:name") })
public class Usergroup implements Serializable {

	@Id
	@GeneratedValue
	private int usergroupid;
	private String name;

	
	/**
	 * Default constructor
	 */
	public Usergroup() {

	}
	/**
	 * Usergroup constructor
	 * 
	 * @param name
	 */
	public Usergroup(String name) {
		this.name = name;	
	}

	public int getUsergroupid() {
		return usergroupid;
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
