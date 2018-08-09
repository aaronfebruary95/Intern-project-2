package group2.bsms.models;

public class Manufacturer {
	private int manufacturerID;
	private String manufacturerName;
	private String manufacturerAddress;

	public Manufacturer(int manufacturerID, String manufacturerName, String manufacturerAddress) {
		super();
		this.manufacturerID = manufacturerID;
		this.manufacturerName = manufacturerName;
		this.manufacturerAddress = manufacturerAddress;
	}

	public int getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(int manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerAddress() {
		return manufacturerAddress;
	}

	public void setManufacturerAddress(String manufacturerAddress) {
		this.manufacturerAddress = manufacturerAddress;
	}

}
