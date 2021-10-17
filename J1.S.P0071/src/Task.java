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

	String getTaskType() {
		return typeMap.get(type);
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