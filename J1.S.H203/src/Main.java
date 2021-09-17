import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static String s;

	private static void printReverse() {
		do {
			System.out.print("Enter a string: ");
			s = in.nextLine();

			if (s.equals("")) {
				System.err.println("Please enter a string.\n");
			} else {
				break;
			}
		} while (true);

		String ret = "";

		ArrayList<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
		Collections.reverse(words);

		for (String w : words) {
			ret += (w + " ");
		}

		ret = ret.trim();

		System.out.println(ret + "\n");
	}

	public static void main(String[] args) {
		printReverse();
	}
}