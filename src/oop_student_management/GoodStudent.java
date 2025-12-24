package oop_student_management;

import java.time.LocalDate;

public class GoodStudent extends Student {
    private double GPA;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, double GPA, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.GPA = GPA;
        this.bestRewardName = bestRewardName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return super.toString() +
                "GoodStudent{" +
                "GPA=" + GPA +
                ", bestRewardName='" + bestRewardName + '\'' +
                '}';
    }

    @Override
    public void ShowMyInfor() {
        System.out.println(this);
    }

    public String getLastName(Student student){
        String[] nameSplit = student.getFullName().split(" ");
        return nameSplit[nameSplit.length-1];
    }
}
