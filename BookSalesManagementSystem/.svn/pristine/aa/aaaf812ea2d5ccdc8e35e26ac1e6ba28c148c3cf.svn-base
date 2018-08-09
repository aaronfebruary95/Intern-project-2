package group2.bsms.repository;


import java.sql.*;

import group2.bsms.connection.DBConnection;

public class AccountRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveAccount(String username) {
		String sql = "SELECT * FROM Account WHERE Username = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ResultSet retrieveAccountAuthority(int accountID) {
		String sql = "SELECT Role FROM Role WHERE AccountID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, accountID);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ResultSet retrieveAccountInformation(int accountID) {
		String sql = "SELECT * FROM UserInformation WHERE AccountID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, accountID);
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public void addAccount(String username, String password, String name) {
		String sql = "INSERT INTO Account VALUES (?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
			
			ResultSet rs = retrieveAccount(username);
			if (!rs.next()) {
				System.out.println("Duplicated account");
			}
			else {
				int accountID = rs.getInt(1);
				sql = "INSERT INTO UserInformation VALUES (?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				statement.setInt(2, accountID);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Duplicated account");
		}
	}
	
	public void updateAccount(int accountID, String condition, String value) {
		String sql = "UPDATE UserInformation SET " + condition + " = ? WHERE AccountID = ?";
		try {
			statement = connection.prepareStatement(sql);
			if (condition.equalsIgnoreCase("Age") || condition.equalsIgnoreCase("PhoneNumber")) 
				statement.setInt(1, Integer.parseInt(value));
			else statement.setString(1, value);
			statement.setInt(2, accountID);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
