package obj;

public class Address {

	// constants
	public static final String CITYNAME = "no city";
	public static final String DISTRICNAME = "no distric";
	public static final String STREETNAME = "no STREET";

	// PROPERTIES
	private String cityName;
	private String districName;
	private String streetName;

	// lam viec voi tat ca cac thuoc tinh
	public Address() {
		this(Address.CITYNAME, Address.DISTRICNAME, Address.STREETNAME);
	}

	// this dùng để tham chiếu đến đối tượng hiện tại(đang sử dụng)- this.cityname
	// là thuộc tính
	// cityName là đối số
	public Address(String cityName, String districName, String streetName) {

		this.cityName = cityName;
		this.districName = districName;
		this.streetName = streetName;
	}

	public Address(Address address) {
		this(address.getCityName(), address.getDistricName(), address.getStreetName());
	}

	/// getter setter giao tiep voi tung thuoc thinh cua doi tuong
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
		return;
	}

	public String getDistricName() {
		return districName;
	}

	public void setDistricName(String districName) {
		this.districName = districName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String toString() {
		return "Address cityName: " + cityName + ", districName=" + districName + ", streetName=" + streetName + "]";
	}

}
