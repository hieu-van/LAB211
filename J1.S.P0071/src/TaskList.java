import java.util.ArrayList;

public class TaskList extends ArrayList<Task> {
	public int getCurrentID() {
		int last_id;
		try {
			last_id = this.get(this.size() - 1).id;
		} catch (IndexOutOfBoundsException e) {
			last_id = 0;
		}

		return last_id;
	}
}
