package application;

import projekt.feukora.server.model.Blower;
import projekt.feukora.server.model.Customer;
import projekt.feukora.server.model.Heater;

public class Context {
	
	
	private static Customer customer;
	private Blower blower;
	
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
		blowername = blower.getName();
		blowertype = blower.getBlowertype();
		fuel = blower.getFuel();
	}
	
	public static void setHeater (Heater heater) {
		heatername = heater.getName();
	}
	
	public static String getHeater () {
		return heatername;
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
	}
}
