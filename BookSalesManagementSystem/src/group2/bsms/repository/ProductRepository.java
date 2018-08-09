package group2.bsms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group2.bsms.connection.DBConnection;

public class ProductRepository {
	Connection connection = DBConnection.getConnection();
	PreparedStatement statement = null;
	
	//condition: Color, ProductName
	public ResultSet retrieveProductList(String condition, String value) {
		String sql = "SELECT * FROM Product WHERE " + condition + " LIKE ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, value);
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	//condition: ManufacturerID, CategoryID
	public ResultSet retrieveProductList(String condition, int value) {
		String sql = "SELECT * FROM Product WHERE " + condition + " = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, value);
			return statement.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	
	//condition: range of Price, Discount
	public ResultSet retrieveProductList(String condition, double bottomPrice, double topPrice) {
		String sql = "SELECT * FROM Product WHERE " + condition + " > ? AND " + condition + " < ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, bottomPrice);
			statement.setDouble(2, topPrice);
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public void addProduct(String value) {
		String sql = "INSERT INTO Product VALUES " + value;
		try {
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDiscountByProductID(float discount, int value) {
		try {
			String sql = "UPDATE Product SET Discount = ? WHERE ProductID = ?";
			statement = connection.prepareStatement(sql);
			statement.setFloat(1, discount);
			statement.setInt(2, value);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void updateDiscountAll(float discount) {
		String sql = "UPDATE Product SET Discount = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setFloat(1, discount);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteDiscountByProductID(int value) {
		try {
			String sql = "UPDATE Product SET Discount = 0 WHERE CategoryID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, value);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//0: out of stock, 1: available
	public void updateAvailabilityByProductID(int productID, int value) {
		String sql = "UPDATE Product SET Availability = ? WHERE ProductID = ?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setInt(2, productID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ProductRepository repo = new ProductRepository();
		ManufacturerRepository manuRepo = new ManufacturerRepository();
		repo.addProduct("(3, 2, 'Oppo Trash 2', 10, 'Black', 'Trash again', 10, 0.5)");
				
		System.out.println();
		ResultSet rs = manuRepo.retrieveIDByName("oppo");
		try {
			if (!rs.next()) System.out.println("No record found!");
			else {
				int manuID = rs.getInt(1);
				rs = repo.retrieveProductList("ManufacturerID", manuID);
				if (!rs.next()) System.out.println("No record found!");
				else {
					do {
						repo.updateAvailabilityByProductID(rs.getInt(1), 0);
					} while (rs.next());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs = repo.retrieveProductList("CategoryID", "%");
		try {
			if (!rs.next()) System.out.println("No record found!");
			else {
				System.out.println("ProductID\tManufacturerID\tCategoryID\tProductName\tPrice\tColor\tDescription\tAvailability\tDiscount");
				do {
					System.out.println(rs.getInt(1) + "\t\t" + rs.getInt(2) + "\t\t" + rs.getInt(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getDouble(5) + "\t"
									 + rs.getString(6) + "\t" + rs.getString(7) + "\t\t" + rs.getInt(8) + "\t\t" + rs.getFloat(9) + "\t");
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
