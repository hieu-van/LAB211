
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskListController {
	public static void addTask(TaskList tasks, int type, String req, String date, float from, float to, String a, String r) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
		LocalDate lc_date = LocalDate.parse(date, formatter);

		int last_id;
		try {
			last_id = tasks.get(tasks.size() - 1).id;
		} catch (IndexOutOfBoundsException e) {
			last_id = 0;
		}

		tasks.add(new Task(last_id + 1, type, req, lc_date, from, to, a, r));
	}

	public static void printAll(TaskList tasks) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("---------------------------- Task (in descending order) ----------------------------");
		System.out.println("ID\tName\tTask Type\tDate\tTime\tAssignee\tReviewer");

		for (int i = tasks.size() - 1; i >= 0; --i) {
			Task t = tasks.get(i);
			System.out.printf("%d\t%s\t%s\t%s\t%.1f\t%s\t%s\n", t.id, t.req_name, t.getTaskType(), t.date.format(formatter), (t.to - t.from), t.assignee, t.reviewer);
		}
	}

	public static boolean deleteTask(TaskList tasks, final int id) {
		if (tasks.stream().filter(t -> (id == t.id)).findFirst().orElse(null) == null) {
			return false;
		}

		tasks.removeIf(t -> (id == t.id));
		return true;
	}
}
