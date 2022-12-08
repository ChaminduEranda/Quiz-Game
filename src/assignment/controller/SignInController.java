package assignment.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import assignment.model.DBConnect;
import assignment.model.SignInModel;
import assignment.view.HomeUI;
import assignment.view.SignInUI;

public class SignInController {

	private SignInUI theView;
	private SignInModel theModel;
	
	public SignInController(SignInUI theView, SignInModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addSignInListener(new SignInListener());
	}
	
	class SignInListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e1) {
			//
				String Uname = theView.getTxtUname().toString();
				String PwPassword = theView.getPwPassword().toString();
				
				if(Uname.equals("")) {
					JOptionPane.showMessageDialog(null, "Username cannot be blank", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else if (PwPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "Password cannot be blank", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else {
				
				DBConnect db = new DBConnect("root", "");
				String sql = "select * from player where username = '"+Uname+"'and password='"+PwPassword+"';";

				try {
					
					db.connect();
					ResultSet rs = db.getStatement().executeQuery(sql);

					if (rs.next()) {
						theView.dispose();
						new HomeUI().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Username or Password is wrong", "Error",
								JOptionPane.ERROR_MESSAGE);
						theView.setPwPassword();
					}
					rs.close();
					//db.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			//
			
		}
		
	}
}
