package application;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import application.model.RuzzleModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RuzzleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label pos00;

    @FXML
    private Label pos01;

    @FXML
    private Label pos02;

    @FXML
    private Label pos03;

    @FXML
    private Label pos10;

    @FXML
    private Label pos11;

    @FXML
    private Label pos12;

    @FXML
    private Label pos13;

    @FXML
    private Label pos21;

    @FXML
    private Label pos22;

    @FXML
    private Label pos33;

    @FXML
    private Label pos32;

    @FXML
    private Label pos31;

    @FXML
    private Label pos30;

    @FXML
    private Label pos24;

    @FXML
    private Label pos23;

    @FXML
    private Button btnGenera;

    @FXML
    private ListView<String> listResult;
    
    private RuzzleModel model;
    private List<Label> labels;
    
    public void setModel(RuzzleModel model){
    	this.model = model;
    }

    @FXML
    void doGenera(ActionEvent event) {
    	for(Label l : labels){
    		l.setText("  "+model.randomChar().toUpperCase());
    	}
    }

    @FXML
    void initialize() {
        assert pos00 != null : "fx:id=\"pos00\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos01 != null : "fx:id=\"pos01\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos02 != null : "fx:id=\"pos02\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos03 != null : "fx:id=\"pos03\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos10 != null : "fx:id=\"pos10\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos11 != null : "fx:id=\"pos11\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos12 != null : "fx:id=\"pos12\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos13 != null : "fx:id=\"pos13\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos21 != null : "fx:id=\"pos21\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos22 != null : "fx:id=\"pos22\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos33 != null : "fx:id=\"pos33\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos32 != null : "fx:id=\"pos32\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos31 != null : "fx:id=\"pos31\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos30 != null : "fx:id=\"pos30\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos24 != null : "fx:id=\"pos24\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert pos23 != null : "fx:id=\"pos23\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert listResult != null : "fx:id=\"listResult\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        
        labels = new ArrayList<Label>();
        labels.add(pos00);
        labels.add(pos01);
        labels.add(pos02);
        labels.add(pos03);
        labels.add(pos10);
        labels.add(pos11);
        labels.add(pos12);
        labels.add(pos13);
        labels.add(pos21);
        labels.add(pos22);
        labels.add(pos23);
        labels.add(pos24);
        labels.add(pos30);
        labels.add(pos31);
        labels.add(pos32);
        labels.add(pos33);
    }
}
