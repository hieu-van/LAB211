import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static int choice;
	private static String inp;
	private static final TaskList tasks = new TaskList();

	private static void addTaskView() {
		int type;
		String req, date_str;
		float from, to;

		do {
			try {
				System.out.print("Enter task type ID: ");
				type = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Invalid number!");
			}
			in.nextLine();
		} while (true);

		System.out.print("Enter requirement name: ");
		req = in.nextLine();

		System.out.print("Enter date (M-d-yyyy): ");
		date_str = in.nextLine();

		do {
			try {
				System.out.print("Plan from: ");
				from = in.nextFloat();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Invalid number!");
			}
			in.nextLine();
		} while (true);

		do {
			try {
				System.out.print("Plan to: ");
				to = in.nextFloat(); in.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Invalid number!");
			}
		} while (true);

		System.out.print("Enter assignee: ");
		String a = in.nextLine();

		System.out.print("Enter reviewer: ");
		String r = in.nextLine();

		TaskListController.addTask(tasks, type, req, date_str, from, to, a, r);

		System.out.println("Added new task.");
	}

	private static void showTasks() {
		TaskListController.printAll(tasks);
	}

	private static void updateTaskView() {
		Task target;

		do {
			System.out.print("Enter task ID: ");
			int id = in.nextInt();
			in.nextLine();

			target = tasks.stream().filter(t -> (id == t.id)).findFirst().orElse(null);
			if (target != null) {
				break;
			} else {
				System.err.println("No task with such ID found.");
			}
		} while (true);

		String inp1, inp2, inp3, inp4, inp5, inp6, inp7;

		System.out.print("Enter task type ID: ");
		inp1 = in.nextLine();

		System.out.print("Enter requirement name: ");
		inp2 = in.nextLine();

		System.out.print("Enter date (M-d-yyyy): ");
		inp3 = in.nextLine();

		System.out.print("Plan from: ");
		inp4 = in.nextLine();

		System.out.print("Plan to: ");
		inp5 = in.nextLine();

		System.out.print("Enter assignee: ");
		inp6 = in.nextLine();

		System.out.print("Enter reviewer: ");
		inp7 = in.nextLine();

		if (TaskController.update(target, inp1, inp2, inp3, inp4, inp5, inp6, inp7)) {
			System.out.println("Task updated successfully.");
		} else {
			System.err.println("Something went wrong.");
		}
	}

	private static void deleteTaskView() {
		int id;

		do {
			System.out.print("Enter task ID: ");
			id = in.nextInt(); in.nextLine();

			if (! TaskListController.deleteTask(tasks, id)) {
				System.err.println("No task with such ID found. Please enter again.");
			} else {
				System.out.println("Task deleted successfully.");
				break;
			}
		} while (true);
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
						addTaskView();
						break;
					case 2:
						updateTaskView();
						break;
					case 3:
						deleteTaskView();
						break;
					case 4:
						showTasks();
						break;
					case 5:
						System.exit(0);
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
