import java.util.TreeMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
	private static final TreeMap<Integer,String> typeMap = new TreeMap();

	private final int id;
	private int type;
	private float from, to;
	private LocalDate date;
	private String reqName, assignee, reviewer;

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getFrom() {
		return from;
	}

	public void setFrom(float from) {
		this.from = from;
	}

	public float getTo() {
		return to;
	}

	public void setTo(float to) {
		this.to = to;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getReqName() {
		return reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	private static void initializeTypes() {
		typeMap.put(1, "Code");
		typeMap.put(2, "Test");
		typeMap.put(3, "Design");
		typeMap.put(4, "Review");
	}

	// Constructor
	public Task(int id, int type, String reqName, LocalDate date, float from, float to, String assignee, String reviewer) {
		initializeTypes();

		this.id = id;
		this.type = type;
		this.reqName = reqName;
		this.date = date;
		this.from = from;
		this.to = to;
		this.assignee = assignee;
		this.reviewer = reviewer;
	}

	public String getTaskType() {
		return typeMap.get(type);
	}

	public boolean update(String inp1, String inp2, String inp3, String inp4, String inp5, String inp6, String inp7) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");

		try {
			if (! "nope".equals(inp1))
				this.type = Integer.parseInt(inp1);

			if (! "nope".equals(inp2))
				this.reqName = inp2;

			if (! "nope".equals(inp3))
				this.date = LocalDate.parse(inp3, formatter);

			if (! "nope".equals(inp4))
				this.from = Float.parseFloat(inp4);

			if (! "nope".equals(inp5))
				this.to = Float.parseFloat(inp5);

			if (! "nope".equals(inp6))
				this.assignee = inp6;

			if (! "nope".equals(inp7))
				this.reviewer = inp7;

			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
