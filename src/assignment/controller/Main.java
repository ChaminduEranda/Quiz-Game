package assignment.controller;

import assignment.model.SignInModel;
/**
 * @author Chamindu
 *
 */
import assignment.view.SignInUI;

public class Main {

	public static void main(String[] args) {
		SignInUI theView = new SignInUI();
		SignInModel theModel = new SignInModel();
		SignInController theController = new SignInController(theView, theModel);
				
		theView.setVisible(true);
	}

}
