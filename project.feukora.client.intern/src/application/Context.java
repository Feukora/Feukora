package application;

import projekt.feukora.server.model.Customer;

public class Context {
	
	
	private Customer customer;
	
	public static String lastname;
	public static String adress;
	public static String phone;
	public static String plz;
	public static String firstname;
	public static String email;
	public static String customerfunction;
	
	public Context() {
		
	}
	
	public static void setCustomer(Customer customer) {
		lastname = customer.getLastname();
    	adress = customer.getAdress();
		phone = customer.getPhone();
    	plz = customer.getTown();
    	firstname = customer.getFirstname();
    	email = customer.getEmail();   	
    	customerfunction = customer.getCustomerfunction();

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
}
