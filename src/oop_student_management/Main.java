package oop_student_management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        List<Student> applicants = new ArrayList<>();
        applicants.add(new GoodStudent("Nguyen Van A", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "KhaGioi", 3.2, "No"));
        applicants.add(new GoodStudent("Nguyen Van B", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "KhaGioi", 3.3, "No"));
        applicants.add(new GoodStudent("Nguyen Van C", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "KhaGioi", 3.4, "No"));
        applicants.add(new GoodStudent("Nguyen Van D", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "KhaGioi", 3.6, "No"));
        applicants.add(new GoodStudent("Nguyen Van E", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "KhaGioi", 3.8, "No"));
        applicants.add(new NormalStudent("Tran Thi G", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "TrungBinh", 600, 400));
        applicants.add(new NormalStudent("Tran Thi H", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "TrungBinh", 600, 400));
        applicants.add(new NormalStudent("Tran Thi J", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "TrungBinh", 600, 400));
        applicants.add(new NormalStudent("Tran Thi K", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "TrungBinh", 600, 400));
        applicants.add(new NormalStudent("Tran Thi L", LocalDate.of(2021, 10, 21), "Nam", "0356508089", "BKA", "TrungBinh", 600, 400));

        int numberNeeded = 14;
        List<Student> selected = studentManagement.recruited(applicants, numberNeeded);

        System.out.println("List of students recruited in the list:");
        for (Student student : selected) {
            System.out.println("- " + student.getFullName());
        }
    }
}
