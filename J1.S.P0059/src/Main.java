import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static int choice;

	private static ArrayList<Person> getPerson(String path, double t_money) {
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
			return null;
		}

		people.sort(new PersonSorter());

		return people;
	}

	private static void copyWordOneTimes(String src, String dest) {
		HashSet<String> words = new HashSet();
		Scanner fileSc, lineSc;

		try {
			fileSc = new Scanner(new File(src));
		} catch (FileNotFoundException e) {
			System.err.println("Source file doesn't exist!");
			return;
		}

		while (fileSc.hasNextLine()) {
			lineSc = new Scanner(fileSc.nextLine());

			while (lineSc.hasNext()) {
				String s = lineSc.next().replaceAll("[^a-zA-Z]", "").toLowerCase().trim();

				if (! s.equals(""))
					words.add(s);
			}
		}

		try (FileWriter fw = new FileWriter(dest)) {
			words.forEach(w -> {
				try {
					fw.write(w + "\n");
				} catch (IOException ex) {
					System.err.println("Cannot write to file!");
				}
			});

			System.out.println("File processed successfully.");
		} catch (IOException ex) {
			System.err.println("Cannot open file for writing!");
		}
	}

	public static void main(String[] args) {
		System.out.println("========== File Processing =========");
		System.out.println("1. Find person info");
		System.out.println("2. Copy text to new file");
		System.out.println("3. Exit");

		do {
			try {
				System.out.print("\nSelect an option: ");
				choice = in.nextInt(); in.nextLine();

				switch (choice) {
					case 1:
						System.out.println("--------- Person info ---------");

						System.out.print("Enter path: ");
						String path = in.nextLine();

						System.out.print("Enter money: ");
						float money = in.nextFloat(); in.nextLine();

						ArrayList<Person> result = getPerson(path, money);

						if (! result.isEmpty()) {
							System.out.println("------------- Result ----------");
							System.out.println("Name\tAddress\tMoney");
							result.forEach(p -> System.out.println(p.getName() + "\t" + p.getAddress() + "\t" + p.getMoney()));
							System.out.printf("\nMax: %s\nMin: %s\n", result.get(result.size() - 1).getName(), result.get(0).getName());
						}

						break;
					case 2:
						System.out.print("Enter source: ");
						String src = in.nextLine();

						System.out.print("Enter destination: ");
						String dest = in.nextLine();

						copyWordOneTimes(src, dest);

						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.err.println("No operation with that number found. Please enter again.");
				}
			} catch (NullPointerException | NumberFormatException | InputMismatchException e) {
				System.err.println("Invalid input. Please enter again.");
				in.nextLine();
			}
		} while (true);
	}
}