import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static int choice;
	private static int id_current = 0;
	private static ArrayList<Task> tasks = new ArrayList();

	private static void addTask() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");

		System.out.print("Enter task type ID: ");
		int type = in.nextInt();
		in.nextLine();

		System.out.print("Enter requirement name: ");
		String req = in.nextLine();

		System.out.print("Enter date (M-d-yyyy): ");
		String date_str = in.nextLine();
		LocalDate date = LocalDate.parse(date_str, formatter);

		System.out.print("Plan from: ");
		float from = in.nextFloat();
		in.nextLine();

		System.out.print("Plan to: ");
		float to = in.nextFloat();
		in.nextLine();

		System.out.print("Enter assignee: ");
		String a = in.nextLine();

		System.out.print("Enter reviewer: ");
		String r = in.nextLine();

		id_current++;
		tasks.add(new Task(id_current, type, req, date, from, to, a, r));

		System.out.println("Added new task.");
	}

	private static void showTasks() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("---------------------------- Task (in descending order) ----------------------------");
		System.out.println("ID\tName\tTask Type\tDate\tTime\tAssignee\tReviewer");

		tasks.forEach(t -> {
			System.out.printf("%d\t%s\t%s\t%s\t%.1f\t%s\t%s\n", t.id, t.req_name, t.getTaskType(), t.date.format(formatter), (t.to - t.from), t.assignee, t.reviewer);
		});
	}

	private static void updateTask() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
		Task target;
		String inp;

		do {
			System.out.print("Enter task ID: ");
			int id = in.nextInt();
			in.nextLine();

			target = tasks.stream().filter(t -> (id == t.id)).findFirst().orElse(null);
			if (target != null) {
				break;
			} else {
				System.out.println("No task with such ID found.");
			}
		} while (true);

		try {
			System.out.print("Enter task type ID: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.type = Integer.parseInt(inp);

			System.out.print("Enter requirement name: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.req_name = inp;

			System.out.print("Enter date (M-d-yyyy): ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.date = LocalDate.parse(inp, formatter);

			System.out.print("Plan from: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.from = Float.parseFloat(inp);

			System.out.print("Plan to: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.to = Float.parseFloat(inp);

			System.out.print("Enter assignee: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.assignee = inp;

			System.out.print("Enter reviewer: ");
			inp = in.nextLine();
			if (! "nope".equals(inp))
				target.reviewer = inp;

			System.out.println("Task updated successfully.");
		}
		catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	private static void deleteTask() {
		int id;

		do {
			System.out.print("Enter task ID: ");
			id = in.nextInt();
			in.nextLine();

			final int idf = id;
			if (tasks.stream().filter(t -> (idf == t.id)).findFirst().orElse(null) != null) {
				break;
			} else {
				System.out.println("No task with such ID found.");
			}
		} while (true);

		final int idf = id;
		tasks.removeIf(t -> (idf == t.id));

		System.out.println("Task deleted successfully.");
	}

	public static void main(String[] args) {
		System.out.println("====== Task program ======");
		System.out.println("1. Add task");
		System.out.println("2. Update task");
		System.out.println("3. Delete task");
		System.out.println("4. Display task");
		System.out.println("5. Exit");

		do {
			try {
				System.out.print("\nSelect an operation: ");
				choice = in.nextInt();
				in.nextLine();

				switch (choice) {
					case 1:
						addTask();
						break;
					case 2:
						updateTask();
						break;
					case 3:
						deleteTask();
						break;
					case 4:
						showTasks();
						break;
					case 5:
						System.exit(0);
					default:
						System.out.println("No operation with that number found. Please enter again.");
				}
			} catch (NullPointerException | NumberFormatException | InputMismatchException e) {
				System.out.println("Invalid input. Please enter again.");
				in.nextLine();
			}
		} while (true);
	}
}
