package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Facilitymanager implements Serializable {

	
	@Id
	@GeneratedValue
	private int facilitymanagerid;
	private String lastname;
	private String firstname;
	private String phone;
	private String email;
	
	public Facilitymanager() {
		
	}
	
	public Facilitymanager(int facilitymanagerid, String lastname, String firstname, String phone, String email) {
		this.facilitymanagerid = facilitymanagerid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
		this.email = email;
	}
	
	public int getFacilitymanagerid() {
		return facilitymanagerid;
	}
	public void setFacilitymanagerid(int facilitymanagerid) {
		this.facilitymanagerid = facilitymanagerid;
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
