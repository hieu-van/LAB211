import java.util.Comparator;

public class PersonSorter implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		return (new Float(p1.money)).compareTo(p2.money);
	}
}
