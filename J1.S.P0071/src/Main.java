import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	private static final Scanner in = new Scanner(System.in);
	private static int choice;

	private static final TaskList tasks = new TaskList();

	private static void addTaskView() {
		String type, reqName, dateStr, from, to, assignee, reviewer;

		// Nhập vào mã loại công việc
		do {
			System.out.print("Enter task type ID: ");
			type = in.nextLine();

			if (Validator.validateTaskType(null, type))
				break;
			else
				System.err.println("Invalid task type!");
		} while (true);

		// Nhập vào tên
		do {
			System.out.print("Enter requirement name: ");
			reqName = in.nextLine();

			if (Validator.validateString(null, reqName))
				break;
			else
				System.err.println("Requirement name must not be empty!");
		} while (true);

		// Nhập vào ngày giao việc
		do {
			System.out.print("Enter date (M-d-yyyy): ");
			dateStr = in.nextLine();

			if (Validator.validateDate(null, dateStr)) {
				break;
			} else
				System.err.println("Invalid date! Please enter again.");
		} while (true);

		// Nhập vào thời gian
		do {
			System.out.print("Plan from: ");
			from = in.nextLine();

			System.out.print("Plan to: ");
			to = in.nextLine();

			// Kiểm tra thời gian nhập vào có hợp lệ không
			if (! Validator.validateTime(null, from, to)) {
				System.err.println("Invalid time! Please enter again.");
			} else {
				break;
			}
		} while (true);

		// Nhập vào người được giao việc
		do {
			System.out.print("Enter assignee: ");
			assignee = in.nextLine();

			if (Validator.validateString(null, assignee))
				break;
			else
				System.err.println("Assignee must not be empty!");
		} while (true);

		// Nhập vào người đánh giá việc
		do {
			System.out.print("Enter reviewer: ");
			reviewer = in.nextLine();

			if (Validator.validateString(null, reviewer))
				break;
			else
				System.err.println("Reviewer must not be empty!");
		} while (true);

		// Thêm công việc vừa tạo vào danh sách các công việc
		tasks.addTask(type, reqName, dateStr, from, to, assignee, reviewer);

		System.out.println("Added new task.");
	}

	private static void showTasks() {
		tasks.printAll();
	}

	private static int enterTaskIdView() {
		int id;
		do {
			try {
				System.out.print("Enter task ID: ");
				id = in.nextInt(); in.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Invalid task ID. Please enter again.");
				in.nextLine();
			}
		} while (true);

		return id;
	}

	private static void updateTaskView() {
		if (tasks.isEmpty()) {
			System.err.println("There are no tasks.");
			return;
		}

		Task target;
		do {
			int id = enterTaskIdView();
			target = tasks.findTaskById(id);

			if (target != null) {
				break;
			} else {
				System.err.println("No task with such ID found. Please enter again.");
			}
		} while (true);

		// Các biến dùng để lưu dữ liệu thay thế
		String type, reqName, dateStr, from, to, assignee, reviewer;

		// Nhập vào mã loại công việc
		do {
			System.out.print("Enter task type ID: ");
			type = in.nextLine();

			if (Validator.validateTaskType(target, type))
				break;
			else
				System.err.println("Invalid task type!");
		} while (true);

		// Nhập vào tên
		do {
			System.out.print("Enter requirement name: ");
			reqName = in.nextLine();

			if (Validator.validateString(target, reqName))
				break;
			else
				System.err.println("Requirement name must not be empty!");
		} while (true);

		// Nhập vào ngày giao việc
		do {
			System.out.print("Enter date (M-d-yyyy): ");
			dateStr = in.nextLine();

			if (Validator.validateDate(target, dateStr)) {
				break;
			} else
				System.err.println("Invalid date! Please enter again.");
		} while (true);

		// Nhập vào thời gian
		do {
			System.out.print("Plan from: ");
			from = in.nextLine();

			System.out.print("Plan to: ");
			to = in.nextLine();

			// Kiểm tra thời gian nhập vào có hợp lệ không
			if (! Validator.validateTime(target, from, to)) {
				System.err.println("Invalid time! Please enter again.");
			} else {
				break;
			}
		} while (true);

		// Nhập vào người được giao việc
		do {
			System.out.print("Enter assignee: ");
			assignee = in.nextLine();

			if (Validator.validateString(target, assignee))
				break;
			else
				System.err.println("Assignee must not be empty!");
		} while (true);

		// Nhập vào người đánh giá việc
		do {
			System.out.print("Enter reviewer: ");
			reviewer = in.nextLine();

			if (Validator.validateString(target, reviewer))
				break;
			else
				System.err.println("Reviewer must not be empty!");
		} while (true);

		// Cập nhật
		target.update(type, reqName, dateStr, from, to, assignee, reviewer);
		System.out.println("Task updated successfully!");
	}

	private static void deleteTaskView() {
		if (tasks.isEmpty()) {
			System.err.println("There are no tasks.");
			return;
		}

		int id = enterTaskIdView();
		if (tasks.findTaskById(id) != null) {
			tasks.deleteTaskById(id);
			System.out.println("Task deleted successfully.");
		} else {
			System.err.println("No task with such ID found!");
		}
	}

	public static void main(String[] args) {
		System.out.println("====== Task program ======");
		System.out.println("1. Add task");
		System.out.println("2. Update task");
		System.out.println("3. Delete task");
		System.out.println("4. Display task");
		System.out.println("5. Exit");

		// Vòng lặp chính
		do {
			do {
				try {
					System.out.print("\nSelect an operation: ");
					choice = in.nextInt(); in.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.err.println("Invalid input. Please enter again.");
					in.nextLine();
				}
			} while (true);

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
		} while (true);
	}
}