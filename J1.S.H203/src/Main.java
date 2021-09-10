import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static String inp;

	private static void printReverse(String s) {
		ArrayList<String> words = new ArrayList<>(Arrays.asList(s.split(" ")));
		Collections.reverse(words);
		words.forEach(w -> System.out.print(w + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		do {
			System.out.print("Enter a string: ");
			inp = in.nextLine();

			if (inp.equals("")) {
				System.err.println("Please enter a string.");
			} else {
				break;
			}
		} while (true);

		printReverse(inp);
	}
}
