package obj;

public class StudentManager extends Manager {

	@Override
	public String info(Person p) {
		// TODO Auto-generated method stub
		return "SM: " + p.toString();
	}

	@Override
	public String getAddress(Person p) {
		// TODO Auto-generated method stub
		return "SM: " + p.getFullAddress().toString();
	}

}
