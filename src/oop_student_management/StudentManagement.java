package oop_student_management;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentManagement {
    private List<Student> students;

     public StudentManagement() {
        this.students = new ArrayList<>();
     }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
         this.students.add(student);
    }

    public List<GoodStudent> getSortedGoodStudent(List<GoodStudent> goodStudents) {
         return goodStudents.stream().sorted(Comparator.comparing(GoodStudent::getGPA).reversed().thenComparing(GoodStudent::getFullName)).collect(Collectors.toList());
    }

    public List<NormalStudent> getSortedNormalStudent(List<NormalStudent> normalStudents) {
         return normalStudents.stream().sorted(Comparator.comparing(NormalStudent::getEntryTestScore).reversed().thenComparing(NormalStudent::getEnglishScore).thenComparing(NormalStudent::getFullName)).collect(Collectors.toList());
    }

    public List<Student> recruited(List<Student> applicants, int numberNeeded) {
         if (numberNeeded < 11 || numberNeeded > 15){
             throw new IllegalArgumentException("Number needs to be between 1 and 15");
         }

         List<GoodStudent> goodStudent = new ArrayList<>();
         List<NormalStudent> normalStudent = new ArrayList<>();

         for (Student student : applicants) {
             if ("KhaGioi".equals(student.getGradeLevel())) {
                 if (student instanceof GoodStudent){
                     goodStudent.add((GoodStudent) student);
                 }
             } else {
                 if (student instanceof NormalStudent){
                     normalStudent.add((NormalStudent) student);
                 }
             }
         }

        List<GoodStudent> sortedGood = getSortedGoodStudent(goodStudent);
        List<NormalStudent> sortedNormal = getSortedNormalStudent(normalStudent);

        List<Student> selected = new ArrayList<>();

        if (sortedGood.size() > numberNeeded){
            selected.addAll(sortedGood.subList(0, numberNeeded));
        }else{
            selected.addAll(sortedGood);
            int remaining = numberNeeded - selected.size();

            if (remaining > 0){
                int countToTake = Math.min(remaining, sortedNormal.size());
                selected.addAll(sortedNormal.subList(0, countToTake));
            }
        }

        return selected;
    }
}
