package obj;

import java.util.*;

public interface CTT extends CTX, TPGD, GDS {
	public String searchDetail(Person[] list);

	public String searchDetail(ArrayList<Person> list);

	public String searchDetail(Person[] list, String name);

	public String searchDetail(Person[] list, Address address);

	public String searchDetail(ArrayList<Person> list, String name);
}
