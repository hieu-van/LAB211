import java.util.Scanner;

public class SecondHalfLetters {
	private static int secondHalfLetters(String inp) {
		int c = 0;
		for (int i = 0; i < inp.length(); ++i) {
			char ch = Character.toLowerCase(inp.charAt(i));
			if ('n' <= ch && ch <= 'z') {
				++c;
			}
		}

		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp;

		do {
			System.out.print("Enter string: ");
			inp = sc.nextLine();

			if (inp.isEmpty())
				System.err.println("Please enter something!");
			else if (inp.equals("exit"))
				break;
			else
				System.out.println(secondHalfLetters(inp));
		} while (true);
	}
}
