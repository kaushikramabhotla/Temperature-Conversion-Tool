package com.dr3adl0cks.javaapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label WelcomeLabel;

	@FXML
	public ChoiceBox<String > ChoiceBox;

	@FXML
	public TextField userinput;

	@FXML
	public Button convert;
	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_TEXT = "Fahrenheit to Celsius";
	private boolean isC_TO_F = true;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ChoiceBox.getItems().add(C_TO_F_TEXT);
		ChoiceBox.getItems().add(F_TO_TEXT);

		ChoiceBox.setValue(C_TO_F_TEXT);
		ChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_F_TEXT)){
				isC_TO_F = true;
			}
			else {
				isC_TO_F = false;
			}

		});


		convert.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		String input = userinput.getText();// 23 ==>  "23"
		float enteredTemp = 0.0f;
		try {
			 enteredTemp = Float.parseFloat(input);
		}catch (Exception e){
			warnUser();
			return;
		}
		float newTemp = 0.0f;
		if(isC_TO_F){// C -->F
			newTemp = (enteredTemp*9/5)+32;
		}else {// F-->C
			newTemp = (enteredTemp-32)*5/9;
		}
		display(newTemp);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter A Valid Temperature");
		alert.show();
	}

	private void display(float newTemp) {
		String unit = isC_TO_F? "F":"C";
		System.out.println("The new Temperature is :" + newTemp + unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is : " + newTemp + unit);
		alert.show();
	}
}
