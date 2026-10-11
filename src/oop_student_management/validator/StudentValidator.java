package oop_student_management.validator;

import oop_student_management.exception.InvalidDOBException;
import oop_student_management.exception.InvalidFullNameException;
import oop_student_management.exception.InvalidPhoneNumberException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public class StudentValidator {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(090|098|091|031|035|038)\\d{7}$");

    public static void validateFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new InvalidFullNameException("Full name cannot be empty!");
        }

        String trimmed = fullName.trim();
        if (trimmed.length() < 10 || trimmed.length() > 50) {
            throw new InvalidFullNameException("The student's full name must be between 10 and 50 characters in length (Actual length: " + trimmed.length() + ")!");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new InvalidPhoneNumberException("Phone number cannot be empty!");
        }

        String trimmed = phoneNumber.trim();
        if (!PHONE_PATTERN.matcher(trimmed).matches()) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits and start with 090, 098, 091, 031, 035, or 038 (Actual: " + trimmed + ")!");
        }
    }

    public static LocalDate validateDoB(String doBStr) {
        if (doBStr == null || doBStr.trim().isEmpty()) {
            throw new InvalidDOBException("Date of birth cannot be empty!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date = LocalDate.parse(doBStr.trim(), formatter);
            if (date.isAfter(LocalDate.now())) {
                throw new InvalidDOBException("The date of birth cannot be later than the current date!");
            }
            return date;
        } catch (DateTimeParseException e) {
            throw new InvalidDOBException("The date of birth is not in the dd/MM/yyyy format or is invalid: " + doBStr);
        }
    }

    public static void validateStudent(String fullName, String phoneNumber, String doB) {
        validateFullName(fullName);
        validatePhoneNumber(phoneNumber);
        validateDoB(doB);
    }
}
