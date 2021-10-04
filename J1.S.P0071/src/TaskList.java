import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
	public int getCurrentID() {
		int last_id;
		try {
			last_id = this.get(this.size() - 1).getId();
		} catch (IndexOutOfBoundsException e) {
			last_id = 0;
		}

		return last_id;
	}

	public void addTask(int type, String req, String date, float from, float to, String a, String r) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
		LocalDate lc_date = LocalDate.parse(date, formatter);

		this.add(new Task(this.getCurrentID() + 1, type, req, lc_date, from, to, a, r));
	}

	public void printAll() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("---------------------------- Task (in descending order) ----------------------------");
		System.out.println("ID\tName\tTask Type\tDate\tTime\tAssignee\tReviewer");

		for (int i = this.size() - 1; i >= 0; --i) {
			Task t = this.get(i);
			System.out.printf("%d\t%s\t%s\t%s\t%.1f\t%s\t%s\n", t.getId(), t.getReqName(), t.getTaskType(), t.getDate().format(formatter), (t.getTo() - t.getFrom()), t.getAssignee(), t.getReviewer());
		}
	}

	public void deleteTaskById(final int id) {
//		if (this.stream().filter(t -> (id == t.getId())).findFirst().orElse(null) == null) {
//			// Nếu task không tồn tại, trả false
//			return false;
//		}

		this.removeIf(t -> (id == t.getId()));

//		return true;
	}

	public Task findTaskById(final int id) {
		return this.stream().filter(t -> (id == t.getId())).findFirst().orElse(null);
	}
}
