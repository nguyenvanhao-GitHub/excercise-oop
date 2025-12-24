package oop_student_management;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
    public static void validateFullName(String fullName) throws InvalidFullNameException{
        if (fullName.length() < 10 || fullName.length() > 50){
            throw new InvalidFullNameException("The full name must be between 10 and 50 characters");
        }
    }

    public static void validateDoB(String doB) throws InvalidDOBException{
        String doBRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$";
        if (!doB.matches(doBRegex)){
            throw new InvalidDOBException("Date of birth must be in the format of DD/MM/YYYY");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        String phoneRegex = "^(090|098|091|031|035|038)[0-9]{7}$";
        if (!phoneNumber.matches(phoneRegex)) {
            throw new InvalidPhoneNumberException("Phone number not valid");
        }
    }

    public static LocalDate parseDate(String date) throws InvalidDOBException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inputDate = null;
        try {
            inputDate = LocalDate.parse(date, formatter);
            if (!inputDate.isAfter(LocalDate.now())) {
                throw new InvalidDOBException("Date is not future");
            }
            return inputDate;
        }  catch (DateTimeParseException e) {
            throw new InvalidDOBException("Date is not valid");
        }
    }
}
