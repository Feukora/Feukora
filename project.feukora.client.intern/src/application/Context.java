package application;

import projekt.feukora.server.model.Customer;

public class Context {
	
	private static Context INSTANCE = new Context();
	
	private Customer customer;
	
	private Context() {
		
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static Context getInstance() {
		return INSTANCE;
	}
	
	public static void setInstance(Context instance) {
		INSTANCE = instance;
	}

}
