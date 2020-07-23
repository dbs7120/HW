import java.text.DecimalFormat;

public class Refrigerator {

	DecimalFormat formatter = new DecimalFormat("###,###");

	private String serialNumber;
	private String prdouctName;
	private int price;
	private int quantity;
	private int capacity;

	public Refrigerator(String serialNumber, String prdouctName, int price, int quantity, int capacity) {
		super();
		this.serialNumber = serialNumber;
		this.prdouctName = prdouctName;
		this.price = price;
		this.quantity = quantity;
		this.capacity = capacity;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPrdouctName() {
		return prdouctName;
	}

	public void setPrdouctName(String prdouctName) {
		this.prdouctName = prdouctName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "��ǰ ��ȣ: " + serialNumber + ", ��ǰ �̸�: " + prdouctName + ", ����: " + formatter.format(price) + "��, ������: "
				+ quantity + ", ��ǰ�뷮: " + capacity + "L";
	}

}
