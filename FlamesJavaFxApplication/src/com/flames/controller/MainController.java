package com.flames.controller;

import java.util.Objects;

import com.flames.commonValidation.CommonValidation;
import com.flames.fxService.FlamesService;
import com.flames.fxUtility.CommonMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {
	
	@FXML
	private AnchorPane anchorId;
	
	@FXML
	private TextField yourName;
	
	@FXML
	private TextField partnerName;
	
	@FXML
	private Label resultInfo;
	
	FlamesService flamesService = new FlamesService();
	
	CommonValidation commonValidation = new CommonValidation();
	
	public void onSubmit(ActionEvent event) {
		System.out.println("Button pressed");
		if(commonValidation.checkIsEmpty(yourName.getText(), partnerName.getText())) {
			resultInfo.setText(CommonMessage.EMPTY_NAME);
		} else {
			outputRelationship(yourName.getText(), partnerName.getText(), resultInfo);
		}
	}
	
	private void outputRelationship(String name1, String name2, Label resultInformation) {
		if(Objects.nonNull(name1) && Objects.nonNull(name2)) {
			flamesService.predictRelation(yourName, partnerName, resultInformation);
		}
	}

}
