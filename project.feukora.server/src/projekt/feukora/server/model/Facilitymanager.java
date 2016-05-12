package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a facilitymanager
 * 
 * @version 1.2
 * @author Pascal
 *
 */

@Entity
@NamedQueries ({
	@NamedQuery(name = "Facilitymanager.findByfacilitymanagerid", query = "SELECT fm FROM Facilitymanager fm WHERE fm.facilitymanagerid=:facilitymanagerid"),
	@NamedQuery(name = "Facilitymanager.findByLastname", query = "SELECT fm FROM Facilitymanager fm WHERE fm.lastname=:lastname"),
	@NamedQuery(name = "Facilitymanager.findByFirstname", query = "SELECT fm FROM Facilitymanager fm WHERE fm.firstname=:firstname")})
public class Facilitymanager implements Serializable {

	
	@Id
	@GeneratedValue
	@Column(name = "FacilitymanagerID")
	private int facilitymanagerid;
	@Column(name = "Lastname")
	private String lastname;
	@Column(name = "Firstname")
	private String firstname;
	@Column(name = "Phone Number")
	private String phone;
	@Column(name = "Email")
	private String email;
	
	/**
	 * Default constructor
	 */
	public Facilitymanager() {
		
	}
	
	/**
	 * Facilitymanager Constructor
	 * 
	 * @param lastname
	 * @param firstname
	 * @param phone
	 * @param email
	 */
	public Facilitymanager(String lastname, String firstname, String phone, String email) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
		this.email = email;
	}
	
	public int getFacilitymanagerid() {
		return facilitymanagerid;
	}

	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
