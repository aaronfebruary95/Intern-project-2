package group2.bsms.models;

public class ProductInCart {
	private int cartID;
	private int productID;
	private int quantity;

	public ProductInCart(int cartID, int productID, int quantity) {
		super();
		this.cartID = cartID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
