package obj;

public class Student extends Person {
	// constants
	public static final int ID = 0;
	public static final String ID_MANAGE = "(2018)600309";
	public static final String SPECIALY = "NONE";
	public static final byte DEPEN_ID_CLASS = 10;

	// student's properties
	private int id; // mã dùng để tìm kiếm
	private String id_manage; // mã dùng để quản lý
	private String specialy; // chuyên ngành
	private byte depen_id_class;// lớp độc lập

	// constructor method
	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS, Student.ID, Student.ID_MANAGE,
				Student.SPECIALY, Student.DEPEN_ID_CLASS);
	}

	public Student(String firstname, String lastName, Byte age, Address address, int id, String idManage,
			String specialy, byte depenIdClass) {
		// khởi tạo đối tượng cha
		super(firstname, lastName, age, address);
		// thiết lập giá trị các thuộc tính đối tượng con
		this.id = id;
		this.id_manage = idManage;
		this.specialy = specialy;
		this.depen_id_class = depenIdClass;
	}
	// setter getter method

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_manage() {
		return id_manage;
	}

	public void setId_manage(String id_manage) {
		this.id_manage = id_manage;
	}

	public String getSpecialy() {
		return specialy;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}

	public byte getDepen_id_class() {
		return depen_id_class;
	}

	public void setDepen_id_class(byte depen_id_class) {
		this.depen_id_class = depen_id_class;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "id=" + id + ", id_manage=" + id_manage + ", specialy=" + specialy
				+ ", depen_id_class=" + depen_id_class + "]";
	}

	public static void main(String[] args) {
		Address address = new Address();
		Person student = new Student("thuy", "nguyen", (byte) 12, address, 2018600309, "121212", "httt", (byte) 12);
		System.out.println(student.toString());
	}
}
