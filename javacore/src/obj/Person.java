package obj;

public class Person implements Comparable<Person> {
	/**
	 * Person constructor phương thức khởi tạo giá trị ban đầu cho các đối tượng khi
	 * mới được tạo
	 *
	 */

	// hằng
	public static final String FIRSTNAME = "no FIRSTname"; // truyền giá trị ngầm định của thuộc tính
	public static final String LASTNAME = "no lastname";
	public static final Byte AGE = 0;
	public static final Address ADDRESS = new Address();

	// Opject's properties
	private String firstName;
	private String lastName;
	private byte age;
	private Address address;

	// class variable
	private static short count = 0;

// 1-Constructor methods

	public Person() {
		// ĐẶC BIỆT LOẠI 1
		// this.firstName = "no firstName"; //this là đối tượng nội tại của lớp
		// lastName = "no LastName";
		// age = 0;
		// this("no name", "no last name", (byte) 0); // tham chiếu đến constructor đầy
		// đủ nhất
		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);
	}

	// đặc biệt loại 2
	public Person(String firstName, String lastName, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

		this.address = new Address(address);// tạo ra vùng nhớ mới để lưu trữ dữ liệu

		// tăng biến đếm số lượng
		Person.count++; // truy cập thông qua tên lớp
	}

	public String getFirstName() {

		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFullAddress() {
		return this.address.toString();
	}

	public byte getAge() {
		return this.age;
	}

	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person setAge(byte age) {
		this.age = age;
		return this;
	}

	public Person setAddress(String cityName, String districName, String streetName) {
		this.address = new Address(cityName, districName, streetName);
		return this;
	}

	// other method -4
	@Override
	public String toString() {
		// return "Person: firstName:" + firstName + " lastName:" + lastName + " age:" +
		// age + " address:" + address;
		return lastName + " " + firstName + ", tuổi " + age;
	}

	/*
	 * lấy về số lượng đối tượng đã tạo ra trong 1 lớp
	 * 
	 * @return
	 */
	public static int getCount() {
		return Person.count;
	}

	// sau 1 time k use thì hủy
	protected void finalize() throws Throwable {
		// giảm số lượng đối tượng
		Person.count--;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public static String name() {
		Person person = new Person();
		int i = person.getFirstName().lastIndexOf(' ');
		String onlyName = person.getFirstName().substring(i + 1);

		return onlyName;
	}

	public static void main(String[] args) {
		// khai báo và khởi tạo đối tượng
		Address ad = new Address("ha noi", "ha dong", "nhon ");
		Person p;
		Person p1 = new Person(); // dùng constructor 1
		// Person p2 = new Person((byte) 10); // dùng constructor 2 byte k phải là kiểu
		// data ngầm định cần ép kiểu
		// Person p3 = new Person("mạnh ", (byte) 10); // dùng constructor 3
		Person p4 = new Person("hồng mạnh ", "phạm", (byte) 10, ad); // dùng constructor 1

//		System.out.println(p1.toString());
//		System.out.println(p2);
		System.out.println(p4);

		// name(p4);
		System.out.println(p4.name());
//		System.out.println(p4.getFirstOnlyName(p4.firstName));

		// System.out.println(Person.count);
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.getAge()-o.getAge();
	}

}
