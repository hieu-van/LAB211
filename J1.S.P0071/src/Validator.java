// Lớp này chứa các hàm kiểm tra tính hợp lệ của dữ liệu người dùng nhập vào

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
	// Hàm kiểm tra mã của loại công việc
	static boolean validateTaskType(Task task, String typeId) {
		if (task != null && typeId.equals("nope")) {
			return true;
		} else {
			int type;
			try {
				type = Integer.valueOf(typeId);
			} catch (NumberFormatException e) {
				return false;
			}

			return (type >= 1 && type <= 4);
		}
	}

	// Hàm kiểm tra các trường là xâu ký tự đơn thuần,
	// không yêu cầu xử lý đặc biệt
	static boolean validateString(Task task, String field) {
		if (task != null && field.equals("nope"))
			return true;
		else
			return ! field.equals("");
	}

	// Hàm kiểm tra ngày nhập vào
	static boolean validateDate(Task task, String dateString) {
		if (! (task != null && dateString.equals("nope"))) {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d-yyyy");
				LocalDate.parse(dateString, formatter);
			} catch (DateTimeParseException ex) {
				return false;
			}
		}

		return true;
	}

	// Hàm kiểm tra thời gian bắt đầu & kết thúc công việc
	static boolean validateTime(Task task, String from, String to) {
		double timeFrom, timeTo;

		if (task != null && ! from.equals("nope") && to.equals("nope")) {
			timeFrom = Float.parseFloat(from);
			timeTo = task.getTo();
		} else if (task != null && from.equals("nope") && ! to.equals("nope")) {
			timeFrom = task.getFrom();
			timeTo = Float.parseFloat(to);
		} else if (task != null && from.equals("nope") && to.equals("nope")) {
			return true;
		} else {
			try {
				timeFrom = Float.parseFloat(from);
				timeTo = Float.parseFloat(to);
			} catch (NumberFormatException e) {
				return false;
			}
		}

		return (timeFrom < timeTo && 8 <= timeFrom && timeTo <= 17.5);
	}
}