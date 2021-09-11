import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskController {
	public static boolean update(Task target, String inp1, String inp2, String inp3, String inp4, String inp5, String inp6, String inp7) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");

		try {
			if (! "nope".equals(inp1))
				target.type = Integer.parseInt(inp1);

			if (! "nope".equals(inp2))
				target.req_name = inp2;

			if (! "nope".equals(inp3))
				target.date = LocalDate.parse(inp3, formatter);

			if (! "nope".equals(inp4))
				target.from = Float.parseFloat(inp4);

			if (! "nope".equals(inp5))
				target.to = Float.parseFloat(inp5);

			if (! "nope".equals(inp6))
				target.assignee = inp6;

			if (! "nope".equals(inp7))
				target.reviewer = inp7;

			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
