package oop_student_management.exception;

public class InvalidFullNameException extends RuntimeException {
    public InvalidFullNameException(String message) {
        super(message);
    }
}
