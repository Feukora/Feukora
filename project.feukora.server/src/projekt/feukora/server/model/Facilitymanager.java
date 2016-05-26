package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a facilitymanager
 * 
 * @version 1.6
 * @author Pascal
 *
 */

@Entity
@NamedQueries ({
	@NamedQuery(name = "Facilitymanager.findByfacilitymanagerid", query = "SELECT fm FROM Facilitymanager fm WHERE fm.facilitymanagerid=:facilitymanagerid"),
	@NamedQuery(name = "Facilitymanager.findByLastname", query = "SELECT fm FROM Facilitymanager fm WHERE fm.lastname=:lastname")})

public class Facilitymanager implements Serializable {

	@Id
	@GeneratedValue
	private int facilitymanagerid;
	private String lastname;

	/**
	 * Default constructor
	 */
	public Facilitymanager() {

	}

	/**
	 * Facilitymanager Constructor
	 * 
	 * @param lastname
	 */
	public Facilitymanager(String lastname) {
		this.lastname = lastname;
	}

	public int getFacilitymanagerid() {
		return facilitymanagerid;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
}