package mx.gob.tabasco.seguro.view;

import javafx.fxml.FXML;
import mx.gob.tabasco.seguro.MainApp;

public class RootLayoutController {
	 	
	private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleAbrirAsegurado() {
    	this.mainApp.showAsegurados();
    }
    
    @FXML
    private void handleAgregarAsegurado() {

    }
    
    @FXML
    private void handleAyuda() {

    }

}
