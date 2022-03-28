package com.flames.fxService;

import com.flames.commonValidation.CommonValidation;
import com.flames.fxUtility.CommonMessage;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FlamesService {
	
	CommonValidation commonValidation = new CommonValidation();
	
	public void predictRelation(TextField name1, TextField name2, Label resultInfo) {
		String yourName = name1.getText();
		String partnerName = name2.getText();
		int i, j, count = 0, temp = 0;
		for(i = temp;i<yourName.length();i++) {
			for(j = 0;j<partnerName.length();j++) {
				if(String.valueOf(yourName.charAt(i)).equalsIgnoreCase(String.valueOf(partnerName.charAt(j)))) {
					count +=1;
					yourName = yourName.replace(String.valueOf(yourName.charAt(i)), "");
					temp = 0;
					i = temp;
					partnerName = partnerName.replace(String.valueOf(partnerName.charAt(j)), "");
					break;
				}
			}
		}
		
		StringBuffer s3 = new StringBuffer("flames");
		int d = yourName.length()+partnerName.length();
		for(i = 0;i<5;i++) {
			int n = -1, l= 0, p = 0;
			for(j = 1;j<=d;j++) {
				n++;
				l++;
				if(n > s3.length()-1) {
					if(l == d) {
						s3.deleteCharAt(p);
						String s4 = s3.substring(p, s3.length());
						s3.delete(p, s3.length());
						s3.insert(0, s4);
						break;
					} else {
						p++;
						if(p == s3.length()) {
							p = 0;
						}
					}
				}
				else {
					char e = s3.charAt(n);
					if(l == d) {
						s3.deleteCharAt(n);
						String s4 = s3.substring(n, s3.length());
						s3.delete(n, s3.length());
						s3.insert(0, s4);
						break;
					}
				}
			}
		}
		
		char result = s3.charAt(0);
		
		switch(result) {
		case 'f':
			resultInfo.setText(name2.getText() + CommonMessage.RESULT_FRIEND);
			commonValidation.saveConfirmationDialog(name2.getText() + CommonMessage.RESULT_FRIEND);
			break;
		case 'l':
			resultInfo.setText(name2.getText() + CommonMessage.RESULT_LOVE);
			commonValidation.saveConfirmationDialog(name2.getText() + CommonMessage.RESULT_LOVE);
			break;
		case 'a':
			resultInfo.setText(CommonMessage.RESULT_AFFECTION + name2.getText());
			commonValidation.saveConfirmationDialog(CommonMessage.RESULT_AFFECTION + name2.getText());
			break;
		case 'm':
			resultInfo.setText(name2.getText() + CommonMessage.RESULT_MARRIAGE);
			commonValidation.saveConfirmationDialog(name2.getText() + CommonMessage.RESULT_MARRIAGE);
			break;
		case 'e':
			resultInfo.setText(name2.getText() + CommonMessage.RESULT_ENEMY);
			commonValidation.saveConfirmationDialog(name2.getText() + CommonMessage.RESULT_ENEMY);
			break;
		case 's':
			resultInfo.setText(name2.getText() + CommonMessage.RESULT_SISTER);
			commonValidation.saveConfirmationDialog(name2.getText() + CommonMessage.RESULT_SISTER);
			break;
		default:
			resultInfo.setText(CommonMessage.RESULT_ERROR);
			commonValidation.saveConfirmationDialog(CommonMessage.RESULT_ERROR);
		}
	}

}
