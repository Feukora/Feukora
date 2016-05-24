package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Company.findByCompanyid", query = "SELECT com FROM Company com WHERE com.companyid=:companyid"),
	@NamedQuery(name = "Company.findByName", query = "SELECT com FROM Company com WHERE com.name=:name"),
	 })

/**
 * This class refers to a company.
 * 
 * @author Robin
 * @version 1.1
 */

public class Company implements Serializable {
	
	@Id
	@GeneratedValue
	private int companyid;
	private String name;
	private String adress;
	private String phone;
	private String email;
	@ManyToOne
	private Town zip;
	
	/**
	 * Default constructor
	 */
	public Company(){
		
	}
	
	/**
	 * Company constructor
	 * 
	 * @param name
	 * @param adress
	 * @param phone
	 * @param email
	 * @param zip
	 */
	
	public Company(String name, String adress,String phone, String email, Town zip){
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.zip = zip;
	}


	public int getCompanyid() {
		return companyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return name;
	}
}
