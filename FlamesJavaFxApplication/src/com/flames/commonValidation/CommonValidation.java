package com.flames.commonValidation;

import java.util.NoSuchElementException;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

public class CommonValidation {
	
	DialogPane dialogPane = new DialogPane();
	
	public boolean saveConfirmationDialog(String resultInfo) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Your Relationship");
		alert.setHeaderText("Relationship result:");
		alert.setContentText(resultInfo);
		dialogPane = alert.getDialogPane();
		alert.getDialogPane().getStylesheets().add(
		   getClass().getResource("/application.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");
		
		Optional<ButtonType> result = alert.showAndWait();
		try {
			if(result.get() == ButtonType.OK) {
				return true;
			}
		}
		catch (NoSuchElementException exception) {
			return false;
		}
		return false;
	}
	
	public boolean checkIsEmpty(String text1, String text2) {
		if(text1.isEmpty() || text2.isEmpty()) {
			return true;
		}
		return false;
	}

}
