package obj;

import java.util.ArrayList;
import java.util.List;

public interface TPGD {
	public ArrayList<Person> statisticPerson();

	public ArrayList<Person> statisticPerson(List<Person> list);

	public ArrayList<Person> statisticPerson(List<Person> list, byte min_age);

	public ArrayList<Person> statisticPerson(List<Person> list, Address address);
}
