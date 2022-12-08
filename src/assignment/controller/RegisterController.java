/**
 * 
 */
package assignment.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import assignment.model.RegisterModel;
import assignment.view.RegisterUI;

/**
 * @author Chamindu
 *
 */
public class RegisterController {
	
	private RegisterUI theRView;
	private RegisterModel theRModel;
	/**
	 * @param theRView
	 * @param theRModel
	 */
	public RegisterController(RegisterUI theView, RegisterModel theModel) {
		this.theRView = theView;
		this.theRModel = theModel;
		this.theRView.addRegisterListener(new RegisterListener());
	}
	
	class RegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RegisterModel theRModel = new RegisterModel();
			
			String name = theRView.getTxtName();
			String username = theRView.getTxtUsername();
			String newPassword = theRView.getPwNewPassword();
			String confirmPassword = theRView.getPwConfirmPassword();
			
			theRModel.registerPlayer(name,username,newPassword,confirmPassword);
			
		}
		
	}
	

}
