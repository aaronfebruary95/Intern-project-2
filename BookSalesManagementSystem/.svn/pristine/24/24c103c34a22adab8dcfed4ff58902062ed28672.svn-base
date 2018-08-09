package group2.bsms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group2.bsms.connection.DBConnection;


public class ManufacturerRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveIDByName(String manufacturerName) {
		String sql = "SELECT ManufacturerID FROM Manufacturer WHERE ManufacturerName = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, manufacturerName);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
}
