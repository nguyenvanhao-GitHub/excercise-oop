package oop_employee_management.validator;

import oop_employee_management.exception.BirthdayException;
import oop_employee_management.exception.EmailException;
import oop_employee_management.exception.FullNameException;
import oop_employee_management.exception.PhoneException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class EmployeeValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^0\\d{9}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\p{L}\\s]+$");

    public static void validateFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new FullNameException("Họ và tên không được để trống!");
        }
        if (!NAME_PATTERN.matcher(fullName.trim()).matches()) {
            throw new FullNameException("Họ và tên không hợp lệ (không được chứa chữ số hoặc ký tự đặc biệt)!");
        }
    }

    public static void validateBirthday(LocalDate birthDay) {
        if (birthDay == null) {
            throw new BirthdayException("Ngày sinh không được để trống!");
        }
        LocalDate now = LocalDate.now();
        if (birthDay.isAfter(now)) {
            throw new BirthdayException("Ngày sinh không thể lớn hơn ngày hiện tại!");
        }
        if (birthDay.getYear() < 1900) {
            throw new BirthdayException("Năm sinh phải từ năm 1900 trở lại!");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new PhoneException("Số điện thoại không được để trống!");
        }
        if (!PHONE_PATTERN.matcher(phone.trim()).matches()) {
            throw new PhoneException("Số điện thoại không hợp lệ! (Phải gồm 10 chữ số và bắt đầu bằng số 0)");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new EmailException("Email không được để trống!");
        }
        if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new EmailException("Email không hợp lệ! (Ví dụ đúng: example@domain.com)");
        }
    }

    public static void validateEmployee(String fullName, LocalDate birthDay, String phone, String email) {
        validateFullName(fullName);
        validateBirthday(birthDay);
        validatePhone(phone);
        validateEmail(email);
    }
}
