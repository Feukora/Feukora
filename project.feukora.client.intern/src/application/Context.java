package application;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;
import projekt.feukora.server.model.Rapport;
import projekt.feukora.server.model.User;

public class Context {
	
	private static Customer customer;
	private static Blower blower;
	private static Heater heater;
	private static User user;
	private static Rapport rapport;
	private static String role;
	
	public static Integer customerid;
	public static String companyname;
	public static String lastname;
	public static String adress;
	public static String phone;
	public static String plz;
	public static String firstname;
	public static String email;
	public static String customerfunction;
	
	public static String heatername;
	public static String blowername;
	public static String blowertype;
	public static String fuel;
	
	public static Integer userid;
	public static String username;
	public static String password;
	
	public static Integer rapportid;
	public Context() {
		
	}
	
	public static void setCustomer(Customer customer) {
		
		customerid = customer.getCustomerid();
		companyname = customer.getCompanyname();
		lastname = customer.getLastname();
    	adress = customer.getAdress();
		phone = customer.getPhone();
    	plz = customer.getTown();
    	firstname = customer.getFirstname();
    	email = customer.getEmail();   	
    	customerfunction = customer.getCustomerfunction();
    	Context.customer = customer;
	}
	
	public static Customer getCustomer() {
		return customer;
	}
	
	public static Integer getCustomerId() {
		return customerid;
	}
	
	public static String getCustomerCompanyName() {
		return companyname;
	}
	
	public static String getCustomerName() {
		return lastname;
	}
	
public static void setRole(String role) {
		
		Context.role = role;

	} 

	public static String getRole() {
		return role;
	}
	public static String getCustomerAdress() {
		return adress;
	}

	public static String getCustomerPhone() {
		return phone;
	}
	
	public static String getCustomerTown() {
		return plz;
	}
	
	public static String getCustomerFirstname() {
		return firstname;
	}
	
	public static String getCustomerEmail() {
		return email;
	}
	
	public static String getCustomerCustomerfunction() {
		return customerfunction;
	}
	
	public static void setBlower (Blower blower) {
		blowername = blower.toString();
		blowertype = blower.getBlowertype();
		fuel = blower.getFuel();
		Context.blower = blower;
	}
	
	public static Blower getBlower() {
		return blower;
	}
	
	public static void setHeater (Heater heater) {
		Context.heater = heater;
		heatername = heater.toString();
	}
	
	public static String getHeaterName () {
		return heatername;
	}
	
	public static Heater getHeater () {
		return heater;
	}
	
	public static String getBlowername() {
		return blowername;
	}
	
	public static String getBlowerType() {
		return blowertype;
	}
	
	public static String getFuel() {
		return fuel;
	}
	
	public static void setNull() {
		companyname = null;
		lastname = null;
    	adress = null;
		phone = null;
    	plz = null;
    	firstname = null;
    	email = null;   	
    	customerfunction = null;
    	username = null;
    	password = null;
	}
	
	public static void setUser(User user) {
		companyname = null;
		lastname = user.getLastname();
    	adress = user.getAdress();
		phone = user.getPhone();
    	plz = user.getTown();
    	firstname = user.getFirstname();
    	email = user.getEmail();   	
    	username = user.getUsername();
    	password = user.getPassword();
    	userid = user.getUserid();
    	Context.user = user;
	}
	
	public static User getUser() {
		return user;
	}
	
	public static void setRapportid(Rapport rapport) {
		rapportid = rapport.getRapportid();
	}
	public static Integer getRapportid() {
		return rapportid;
	}
}
