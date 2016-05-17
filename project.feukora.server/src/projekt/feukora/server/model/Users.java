package projekt.feukora.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * This class refers to a user.
 * 
 * @version 1.1
 * @author Tamara
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid=:userid"),
	@NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname=:lastname"),
	@NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname=:firstname"),
	@NamedQuery(name = "Users.findByLastnameAndFirstname", query = "SELECT u FROM Users u WHERE u.lastname=:lastname AND u.firstname=:firstname"),
	@NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username=:username") })
public class Users implements Serializable {

	@Id
	@GeneratedValue
	private int userid;
	@ManyToOne
	private Usergroup usergroupid;
	private String lastname;
	private String firstname;
	private String adress;
	@ManyToOne
	private Town zip;
	@ManyToOne
	private Company companyid;
	private String username;
	private String password;
	private String phone;
	private String email;
	
	
	/**
	 * Default constructor
	 */
	public Users(){
		
	}
	
	/**
	 * Users Constructor
	 * 
	 * @param usergroupid
	 * @param lastname
	 * @param firstname
	 * @param adress
	 * @param zip
	 * @param companyid
	 * @param username
	 * @param password
	 * @param phone
	 * @param email
	 */
	public Users(Usergroup usergroupid, String lastname, String firstname,String adress,Town zip,Company companyid,String username, String password,String phone, String email) {
		this.usergroupid = usergroupid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.zip = zip;
		this.companyid = companyid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public int getUserid() {
		return userid;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
