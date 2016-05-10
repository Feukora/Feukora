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
 * This class refers to a user.
 * @author Tamara
 * version 1.0
 *
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
	
	@Embedded
	@ManyToOne
	private Usergroup fi_usergroupid;
	private String lastname;
	private String firstname;
	private String adress;
	
	@Embedded
	@ManyToOne
	private Town fi_zip;
	
	@Embedded
	@ManyToOne
	private Company fi_companyid;
	private String username;
	private String password;
	private String phone;
	private String email;
	
	
	/**
	 * default constructor
	 */
	public Users(){
		
	}
	
	/**
	 * constructor for the class Users
	 * @param userid
	 * @param fi_usergroupid
	 * @param lastname
	 * @param firstname
	 * @param adress
	 * @param fi_zip
	 * @param fi_companyid
	 * @param username
	 * @param password
	 * @param phone
	 * @param email
	 */
	public Users(int userid, Usergroup fi_usergroupid, String lastname, String firstname,String adress,Town fi_zip,Company fi_companyid,String username, String password,String phone, String email) {
		this.userid = userid;
		this.fi_usergroupid = fi_usergroupid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.fi_zip = fi_zip;
		this.fi_companyid = fi_companyid;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
