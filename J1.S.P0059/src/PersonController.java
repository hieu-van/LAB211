import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class PersonController {
	public static ArrayList<Person> getPerson(String path, double t_money) {
		ArrayList<Person> people = new ArrayList();

		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEach(line -> {
				try {
					String name = line.split(";")[0];
					String addr = line.split(";")[1];
					float money;

					try {
						money = Float.parseFloat(line.split(";")[2]);
						if (money < 0)
							throw new NumberFormatException();
					} catch (NumberFormatException e) {
						money = 0;
					}

					if (money >= t_money)
						people.add(new Person(name, addr, money));
				} catch (NullPointerException e) {
					System.err.println("An invalid line was found and ignored.");
				}
			});
		} catch (IOException e) {
			System.err.println("Error reading file!");
		}

		people.sort(new PersonSorter());

		return people;
	}
}