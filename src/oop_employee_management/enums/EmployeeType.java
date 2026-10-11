package oop_employee_management.enums;

public enum EmployeeType {
    EXPERIENCE(0),
    FRESHER(1),
    INTERN(2);

    private final int value;

    EmployeeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EmployeeType fromValue(int val) {
        for (EmployeeType type : values()) {
            if (type.value == val) {
                return type;
            }
        }
        return null;
    }
}
