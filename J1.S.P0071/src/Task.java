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

	private static void initializeTypes() {
		typeMap.put(1, "Code");
		typeMap.put(2, "Test");
		typeMap.put(3, "Design");
		typeMap.put(4, "Review");
	}

	public int getId() {
		return id;
	}

	String getTaskType() {
		return typeMap.get(type);
	}

	public float getFrom() {
		return from;
	}

	public float getTo() {
		return to;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getReqName() {
		return reqName;
	}

	public String getAssignee() {
		return assignee;
	}

	public String getReviewer() {
		return reviewer;
	}

	// Constructor
	Task(int id,
			int type,
			String reqName,
			LocalDate date,
			float from, float to,
			String assignee,
			String reviewer) {
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

	// Cập nhật công việc hiện tại với dữ liệu mới.
	// Các dữ liệu mới này được đảm bảo là hợp lệ.
	void update(String newTypeId,
			String newReqName,
			String newDateStr,
			String newFrom, String newTo,
			String newAss,
			String newRev) {
		if (! "nope".equals(newTypeId))
			this.type = Integer.parseInt(newTypeId);

		if (! "nope".equals(newReqName))
			this.reqName = newReqName;

		if (! "nope".equals(newDateStr)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
			this.date = LocalDate.parse(newDateStr, formatter);
		}

		if (! "nope".equals(newFrom))
			this.from = Float.parseFloat(newFrom);

		if (! "nope".equals(newTo))
			this.to = Float.parseFloat(newTo);

		if (! "nope".equals(newAss))
			this.assignee = newAss;

		if (! "nope".equals(newRev))
			this.reviewer = newRev;
	}
}