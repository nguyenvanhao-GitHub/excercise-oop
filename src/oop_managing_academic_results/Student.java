package oop_managing_academic_results;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String id;
    private String fullName;
    private LocalDate dateOfBirth;
    private int yearOfAdmission;
    private double entryPoint;
    private List<AcademicResult> academicResults;

    // 1. Constructor chuẩn (default)
    public Student() {
        this.academicResults = new ArrayList<>();
    }

    // 2. Constructor có tham số
    public Student(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults) {
        this.id = id;
        setFullName(fullName);
        this.dateOfBirth = dateOfBirth;
        setYearOfAdmission(yearOfAdmission);
        setEntryPoint(entryPoint);
        this.academicResults = academicResults != null ? new ArrayList<>(academicResults) : new ArrayList<>();
    }

    // 3. Constructor sao chép (copy constructor)
    public Student(Student other) {
        if (other != null) {
            this.id = other.id;
            this.fullName = other.fullName;
            this.dateOfBirth = other.dateOfBirth;
            this.yearOfAdmission = other.yearOfAdmission;
            this.entryPoint = other.entryPoint;
            this.academicResults = new ArrayList<>();
            for (AcademicResult ar : other.academicResults) {
                this.academicResults.add(new AcademicResult(ar)); // Deep copy kết quả học tập
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã sinh viên không được để trống!");
        }
        this.id = id.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Họ tên không được để trống!");
        }
        this.fullName = fullName.trim();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày sinh không được ở tương lai!");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirth(String dobStr) {
        try {
            LocalDate date = LocalDate.parse(dobStr.trim(), DATE_FORMATTER);
            setDateOfBirth(date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Ngày sinh không hợp lệ hoặc sai định dạng dd/MM/yyyy: " + dobStr);
        }
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        if (yearOfAdmission < 1950 || yearOfAdmission > 2100) {
            throw new IllegalArgumentException("Năm vào học phải trong khoảng 1950 đến 2100!");
        }
        this.yearOfAdmission = yearOfAdmission;
    }

    public double getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(double entryPoint) {
        if (entryPoint < 0 || entryPoint > 30) {
            throw new IllegalArgumentException("Điểm đầu vào phải từ 0 đến 30!");
        }
        this.entryPoint = entryPoint;
    }

    public List<AcademicResult> getAcademicResults() {
        return academicResults;
    }

    public void setAcademicResults(List<AcademicResult> academicResults) {
        this.academicResults = academicResults != null ? academicResults : new ArrayList<>();
    }

    public void addAcademicResult(AcademicResult result) {
        if (result != null) {
            this.academicResults.add(result);
        }
    }

    // Phương thức xác định sinh viên có phải chính quy hay không
    public boolean isRegularStudent() {
        return false;
    }

    // Phương thức lấy điểm trung bình học kỳ theo tên học kỳ
    public Double getGPABySemester(String semesterName) {
        if (semesterName == null) return null;
        for (AcademicResult ar : academicResults) {
            if (ar.getSemesterName().equalsIgnoreCase(semesterName.trim())) {
                return ar.getSemesterGPA();
            }
        }
        return null;
    }

    // Lấy học kỳ gần nhất (học kỳ cuối cùng trong danh sách)
    public AcademicResult getLatestAcademicResult() {
        if (academicResults.isEmpty()) return null;
        return academicResults.get(academicResults.size() - 1);
    }

    // Lấy điểm trung bình học kỳ cao nhất của sinh viên ở bất kỳ kỳ nào
    public double getMaxSemesterGPA() {
        if (academicResults.isEmpty()) return 0.0;
        double max = 0.0;
        for (AcademicResult ar : academicResults) {
            if (ar.getSemesterGPA() > max) {
                max = ar.getSemesterGPA();
            }
        }
        return max;
    }

    // Phương thức input
    public void input(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        setId(scanner.nextLine());

        System.out.print("Nhập họ tên sinh viên: ");
        setFullName(scanner.nextLine());

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        setDateOfBirth(scanner.nextLine());

        System.out.print("Nhập năm vào học: ");
        setYearOfAdmission(Integer.parseInt(scanner.nextLine().trim()));

        System.out.print("Nhập điểm đầu vào (thang 30): ");
        setEntryPoint(Double.parseDouble(scanner.nextLine().trim()));

        System.out.print("Nhập số lượng học kỳ đã học: ");
        int numSemesters = Integer.parseInt(scanner.nextLine().trim());
        this.academicResults.clear();
        for (int i = 0; i < numSemesters; i++) {
            System.out.println("  > Nhập kết quả học kỳ thứ " + (i + 1) + ":");
            AcademicResult ar = new AcademicResult();
            ar.input(scanner);
            this.academicResults.add(ar);
        }
    }

    // Phương thức output
    public void output() {
        String dob = dateOfBirth != null ? dateOfBirth.format(DATE_FORMATTER) : "N/A";
        System.out.println("Mã SV: " + id +
                " | Họ tên: " + fullName +
                " | Ngày sinh: " + dob +
                " | Năm vào học: " + yearOfAdmission +
                " | Điểm đầu vào: " + entryPoint +
                " | Loại: " + (isRegularStudent() ? "Chính quy" : "Tại chức"));
        if (!academicResults.isEmpty()) {
            System.out.print("  Kết quả học tập: ");
            for (AcademicResult ar : academicResults) {
                System.out.print(ar + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + (dateOfBirth != null ? dateOfBirth.format(DATE_FORMATTER) : "") +
                ", yearOfAdmission=" + yearOfAdmission +
                ", entryPoint=" + entryPoint +
                ", results=" + academicResults +
                '}';
    }
}
