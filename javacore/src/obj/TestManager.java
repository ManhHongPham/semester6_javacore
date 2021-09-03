package obj;

public class TestManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address = new Address();

		Person employee = new Employee("thu", "pham", (byte) 22, address, 20000000, "nhan vien", (short) 2010,
				(short) 2000);
		Person student = new Student("hoa" , "nguyen", (byte)24, address, 12121, "20182323", "he thong", (byte)12);
		//System.out.println(employee.toString());

		//-------------------------------------
		
		StudentManager sm= new StudentManager();
		EmployeeManager em= new EmployeeManager();
		System.out.println(em.info(employee));
		System.out.println(sm.info(student));
	}

}
