package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * This class refers to a customer.
 * 
 * @version 1.0
 * @author Pascal
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Customer,findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid=:customerid"),
	@NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname=:lastname"),
	@NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname=:firstname"),
	@NamedQuery(name = "Customer.findByLastnameAndFirstname", query = "SELECT c FROM Customer c WHERE c.lastname=:lastname AND c.firstname=:firstname"),
	@NamedQuery(name = "Customer.findByAdress", query = "SELECT c FROM Customer c WHERE c.adress=:adress") })
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	private int customerid;
	@Embedded
	@ManyToOne
	private Customerfunction fi_customerfunctionid;
	private String companyname;
	private String firstname;
	private String lastname;
	private String adress;
	private String phone;
	private String email;
	@Embedded
	@ManyToOne
	private Town fi_zip;
	 
	public Customer() {
		
	}
	
	public Customer (String companyname, String lastname, String firstname, String adress, String phone, String email, Customerfunction fi_customerfunctionid, Town fi_zip) {
		this.companyname = companyname;
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.fi_customerfunctionid = fi_customerfunctionid;
		this.fi_zip = fi_zip;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
