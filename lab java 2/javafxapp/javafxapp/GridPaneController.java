package javafxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class GridPaneController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    @FXML
    public void btnFindClick(ActionEvent event) {
        System.out.println("Find!");
    }
    
    @FXML
    public void btnCancelClick(ActionEvent event) {
        System.out.println("Try to Cancel!");
    }    
}
