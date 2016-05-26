package projekt.feukora.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * This class refers to a user.
 * 
 * @version 1.6
 * @author Tamara
 */

@Entity
@Table(name="\"user\"")
@NamedQueries({
	@NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid=:userid"),
	@NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname=:lastname"),
	@NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname=:firstname"),
	@NamedQuery(name = "User.findByLastnameAndFirstname", query = "SELECT u FROM User u WHERE u.lastname=:lastname AND u.firstname=:firstname"),
	@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username=:username"),
	@NamedQuery(name = "User.findByUsergroup", query = "SELECT u FROM User u WHERE u.usergroupid=:usergroup")})

public class User implements Serializable {

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
	public User(){
		
	}
	
	/**
	 * User Constructor
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
	public User(Usergroup usergroupid, String lastname, String firstname,String adress,Town zip,Company companyid,String username, String password,String phone, String email) {
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

	public void setZip(Town zip) {
		this.zip = zip;
	}

	public void setCompanyid(Company companyid) {
		this.companyid = companyid;
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
	public String getTown(){
		return zip.toString();
	}
	
	public String getCompany() {
		return companyid.toString();
	}
	
	/**
	 * Returns the currently logged in user or null if the credentials were wrong
	 * 
	 * @param password
	 * @return
	 */
	public User login( String password )
	{
		return this.password.equals( password ) ? this : null;
	}

	public void setUsergroupid(Usergroup usergroupid) {
		this.usergroupid = usergroupid;
	}

	public Usergroup getUsergroupid() {
		return usergroupid;
	}
	
	@Override
	public String toString() {
		return lastname + " " + firstname;
	}
}