package group2.bsms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group2.bsms.connection.DBConnection;

public class ShipperRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveShipper(int shipperID) {
		String sql = "SELECT * FROM Shipper WHERE ShipperID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, shipperID);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public void addShipper(String companyName) {
		String sql = "INSERT INTO Shipper VALUES (?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, companyName);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
