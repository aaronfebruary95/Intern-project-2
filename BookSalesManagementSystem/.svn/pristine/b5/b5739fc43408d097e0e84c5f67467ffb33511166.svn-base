package group2.bsms.repository;

import java.sql.*;

import group2.bsms.connection.DBConnection;

public class CartRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveProductsInCart(int cartID) {
		String sql = "SELECT * FROM ProductInCart WHERE CartID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartID);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public void addProduct(int cartID, int productID, int quantity) {
		String sql = "INSERT INTO ProductInCart VALUES (?, ?, ?)";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartID);
			statement.setInt(2, productID);
			statement.setInt(3, quantity);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateProductQuantity(int cartID, int productID, int quantity) {
		String sql = "UPDATE ProductInCart SET Quantity = ? WHERE CartID = ? AND ProductID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, quantity);
			statement.setInt(2, cartID);
			statement.setInt(3, productID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public double calculateCartTotal(int cartID) {
		String sql = "SELECT SUM(Price * (1 - Discount) * Quantity) FROM ProductInCart\r\n" + 
				"INNER JOIN Product ON Product.ProductID = ProductInCart.ProductID\r\n" + 
				"WHERE ProductInCart.CartID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartID);
			ResultSet rs = statement.executeQuery();
			if (!rs.next()) return 0;
			else return rs.getDouble(1);
		} catch (SQLException e) {
			return 0;
		}
	}
}
