package oop_employee_management;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
    public static LocalDate validateBirthday(String birthday) throws BirthDayException {
        if (birthday == null || birthday.trim().isEmpty()) {
            throw new BirthDayException("Birthday cannot be empty");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate inputDate = LocalDate.parse(birthday, formatter);
            if (inputDate.isAfter(LocalDate.now())) {
                throw new BirthDayException("Birthday cannot be in the future");
            }
            return inputDate;
        } catch (DateTimeParseException e) {
            throw new BirthDayException("Birthday format is not valid (dd/MM/yyyy)");
        }
    }

    public static void validateEmail(String email) throws EmailException {
        if (email == null || email.trim().isEmpty()) {
            throw new EmailException("Email cannot be empty");
        }
        String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(regexEmail)) {
            throw new EmailException("Invalid email format");
        }
    }

    public static void validateName(String name) throws FullNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new FullNameException("Name cannot be empty");
        }
        String regexName = "^[\\p{L} ]+$";
        if (!name.matches(regexName)) {
            throw new FullNameException("Invalid name format");
        }
    }

    public static void validatePhone(String phone) throws PhoneException {
        if (phone == null || phone.trim().isEmpty()) {
            throw new PhoneException("Phone cannot be empty");
        }
        String regexPhone = "^0\\d{9,10}$";
        if (!phone.matches(regexPhone)) {
            throw new PhoneException("Invalid phone number");
        }
    }
}
