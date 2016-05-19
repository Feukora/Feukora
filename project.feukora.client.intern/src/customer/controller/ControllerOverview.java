package customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import projekt.feukora.client.intern.ClientInternRMI;


public class ControllerOverview {

	 @FXML
	public void initialize() {
		 try {
				ClientInternRMI feukora = new ClientInternRMI();
				feukora.showCustomer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

    @FXML
    private Button overviewDeleteCustomer;
    
    @FXML
    void ActionOverviewDeleteCustomer(ActionEvent event) {
    	
    }
}
