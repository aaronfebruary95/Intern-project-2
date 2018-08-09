package group2.bsms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group2.bsms.connection.DBConnection;



public class CategoryRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	public ResultSet retrieveIDByName(String categoryName) {
		String sql = "SELECT CategoryID FROM Category WHERE CategoryName = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, categoryName);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
}
