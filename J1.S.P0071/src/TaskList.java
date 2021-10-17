import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
	int getLastID() {
		// ID của công việc được thêm vào cuối cùng trong danh sách
		int lastId;

		try {
			lastId = this.get(this.size() - 1).getId();
		} catch (IndexOutOfBoundsException e) {
			// Trường hợp này là trong DS không có phần tử nào.
			// Khi đó đặt ID cuối cùng là 0.
			lastId = 0;
		}

		return lastId;
	}

	void addTask(String typeIdStr,
			String reqName,
			String dateStr,
			String fromStr, String toStr,
			String asnee,
			String rev) {
		int type = Integer.parseInt(typeIdStr);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
		LocalDate dateObj = LocalDate.parse(dateStr, formatter);

		float timeFrom = Float.parseFloat(fromStr);
		float timeTo = Float.parseFloat(toStr);

		int newTaskId = this.getLastID() + 1;
		Task newTask = new Task(newTaskId, type, reqName, dateObj, timeFrom, timeTo, asnee, rev);
		this.add(newTask);
	}

	void printAll() {
		if (this.isEmpty()) {
			System.err.println("There are no tasks.");
			return;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("---------------------------- Task (in descending order) ----------------------------");

		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
			"ID",
			"Name",
			"Task Type",
			"Date",
			"Time",
			"Assignee",
			"Reviewer"
		);

		for (int i = this.size() - 1; i >= 0; --i) {
			Task t = this.get(i);

			System.out.printf("%-15s %-15s %-15s %-15s %-15.1f %-15s %-15s\n",
				t.getId(),
				t.getReqName(),
				t.getTaskType(),
				t.getDate().format(formatter),
				(t.getTo() - t.getFrom()),
				t.getAssignee(),
				t.getReviewer()
			);
		}
	}

	void deleteTaskById(final int id) {
		this.removeIf(t -> (id == t.getId()));
	}

	Task findTaskById(final int id) {
		return this.stream().filter(t -> (id == t.getId())).findFirst().orElse(null);
	}
}