package group2.bsms.models;

public class ShipOrder {
	private int shiporderID;
	private String shipDate;
	private int shipperID;

	public ShipOrder(int shiporderID, String shipDate, int shipperID) {
		super();
		this.shiporderID = shiporderID;
		this.shipDate = shipDate;
		this.shipperID = shipperID;
	}

	public int getShiporderID() {
		return shiporderID;
	}

	public void setShiporderID(int shiporderID) {
		this.shiporderID = shiporderID;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public int getShipperID() {
		return shipperID;
	}

	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}

}
