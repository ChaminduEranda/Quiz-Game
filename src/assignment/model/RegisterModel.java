/**
 * 
 */
package assignment.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

/**
 * Model class for the player registering
 * @author Chamindu
 *
 */
public class RegisterModel {
	String name, username, newPassword, confirmPassword = null;

	public void registerPlayer(String name, String username, String newPassword, String confirmPassword) {
		if (name == "") {
			JOptionPane.showMessageDialog(null, "Name cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (username == "") {
			JOptionPane.showMessageDialog(null, "Username cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (newPassword == "") {
			JOptionPane.showMessageDialog(null, "Password cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (newPassword != confirmPassword) {
			JOptionPane.showMessageDialog(null, "Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			DBConnect db = new DBConnect("root", "");
			String sql = "insert into player where username='" + username + "'and password='" + confirmPassword + "'";

			try {
				db.connect();
				Connection con = db.getConnection();
				PreparedStatement stm = con.prepareStatement(sql);

				int i = stm.executeUpdate();
				if (i == 1) {
					JOptionPane.showMessageDialog(null, "Player added successfully", "InfoBox",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Registration failed", "InfoBox",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
