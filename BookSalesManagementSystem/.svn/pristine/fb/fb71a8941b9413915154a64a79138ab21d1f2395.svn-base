package group2.bsms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group2.bsms.connection.DBConnection;

public class OrderRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveOrder(int orderID) {
		String sql = "SELECT * FROM Order WHERE OrderID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderID);
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public int addShipOrder(String shipDate, int shipperID) {
		String sql = "INSERT INTO ShipOrder VALUES (?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, shipDate);
			statement.setInt(2, shipperID);
			statement.executeUpdate();
			
			sql = "SELECT TOP 1 * FROM ShipOrder ORDER BY ShipOrderID DESC";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public void addOrder(int cartID, String paymentMethod, int shipOrderID) {
		String sql = "INSERT INTO Order VALUES (?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartID);
			statement.setString(2, paymentMethod);
			statement.setInt(3, shipOrderID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
