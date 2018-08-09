package group2.bsms.models;

public class Cart {
	private int cartID;
	private int accountID;

	public Cart(int cartID, int accountID) {
		super();
		this.cartID = cartID;
		this.accountID = accountID;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

}
