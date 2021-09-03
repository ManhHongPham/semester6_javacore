package obj;

public class Employee extends Person {
	// constants
	public static final int NET = 0;
	public static final String POSITION = "NONE";
	public static final short APPLYYEAR = 0;
	public static final short DEPARTID = 0;

	private int net;
	private String position;
	private short applyYear;
	private short departID;

	public Employee(String firstName, String lastName, byte age, Address address, int net, String position,
			short applyYear, short departID) {
		super(firstName, lastName, age, address);
		this.net = net;
		this.position = position;
		this.applyYear = applyYear;
		this.departID = departID;
	}

	public Employee() {
		super();
	}

	public int getNet() {
		return net;
	}

	public void setNet(int net) {
		this.net = net;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public short getApplyYear() {
		return applyYear;
	}

	public void setApplyYear(short applyYear) {
		this.applyYear = applyYear;
	}

	public short getDepartID() {
		return departID;
	}

	public void setDepartID(short departID) {
		this.departID = departID;
	}

	@Override
	public String toString() {
		return "Employee [" + super.toString() + "net=" + net + ", position=" + position + ", applyYear=" + applyYear
				+ ", departID=" + departID + "]";
	}

	public static void main(String[] args) {
	}
}
