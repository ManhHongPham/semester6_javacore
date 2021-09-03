package obj;

import java.util.ArrayList;
import java.util.List;

public interface GDS {
	public ArrayList<Person> setPosition(Person p);

	public ArrayList<Person> setPosition(List<Person> list, String name);

	public ArrayList<Person> setPosition(List<Person> list, Address address);

}
