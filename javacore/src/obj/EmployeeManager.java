package obj;

public class EmployeeManager extends Manager {

	@Override
	public String info(Person p) {
		// TODO Auto-generated method stub
		return "EM: "+ p.toString();
	}

	@Override
	public String getAddress(Person p) {
		// TODO Auto-generated method stub
		return "EM: "+p.getFullAddress().toString();
	}

}
