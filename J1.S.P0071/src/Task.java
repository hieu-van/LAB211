import java.util.TreeMap;
import java.time.LocalDate;

public class Task {

	private static final TreeMap<Integer,String> typeMap = new TreeMap();

	public int id, type;
	public float from, to;
	public LocalDate date;
	public String req_name, assignee, reviewer;

	private static void initializeTypes() {
		typeMap.put(1, "Code");
		typeMap.put(2, "Test");
		typeMap.put(3, "Design");
		typeMap.put(4, "Review");
	}

	// Constructor
	public Task(int id, int type, String req_name, LocalDate date, float from, float to, String assignee, String reviewer) {
		initializeTypes();

		this.id = id;
		this.type = type;
		this.req_name = req_name;
		this.date = date;
		this.from = from;
		this.to = to;
		this.assignee = assignee;
		this.reviewer = reviewer;
	}

	public String getTaskType() {
		return typeMap.get(type);
	}
}
