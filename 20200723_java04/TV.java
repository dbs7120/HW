import java.text.DecimalFormat;

public class TV {

	DecimalFormat formatter = new DecimalFormat("###,###");

	private String serialNumber;
	private String prdouctName;
	private int price;
	private int quantity;
	private int inch;
	private String displayType; // led lcd oled

	public TV(String serialNumber, String prdouctName, int price, int quantity, int inch, String displayType) {
		super();
		this.serialNumber = serialNumber;
		this.prdouctName = prdouctName;
		this.price = price;
		this.quantity = quantity;
		this.inch = inch;
		this.displayType = displayType;
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "제품 번호: " + serialNumber + ", 제품 이름: " + prdouctName + ", 가격: " + formatter.format(price) + ", quantity="
				+ quantity + ", 화면크기: " + inch + "inch, 화면종류: " + displayType.toUpperCase();
	}

}
