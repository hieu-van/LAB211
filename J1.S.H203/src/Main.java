import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static final Scanner in = new Scanner(System.in);

	private static void printReverse() {
		String s;
		do {
			System.out.print("Enter a string: ");
			s = in.nextLine();

			if (s.equals("")) {
				System.err.println("Please enter a string.\n");
			} else {
				break;
			}
		} while (true);

		StringBuilder ret = new StringBuilder();

		ArrayList<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
		Collections.reverse(words);

		for (String w : words) {
			ret.append(w).append(" ");
		}

		ret = new StringBuilder(ret.toString().trim());

		System.out.println(ret + "\n");
	}

	public static void main(String[] args) {
		printReverse();
	}
}