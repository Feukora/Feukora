package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a usergroup.
 * @author Tamara
 * @version 1.0
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
	 * default constructor
	 */
	public Usergroup() {

	}
	/**
	 * constructor for the class Usergroup
	 * @param usergroupid
	 * @param name
	 */
	public Usergroup(int usergroupid, String name) {
		this.usergroupid = usergroupid;
		this.name = name;
		
	}

	public int getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(int usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
