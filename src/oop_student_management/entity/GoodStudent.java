package oop_student_management.entity;

import java.time.LocalDate;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    @Override
    public void showMyInfor() {
        System.out.println(this);
    }

    public GoodStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                "fullName='" + getFullName() + '\'' +
                ", doB=" + getDoB() +
                ", sex='" + getSex() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", universityName='" + getUniversityName() + '\'' +
                ", gradeLevel='" + getGradeLevel() + '\'' +
                ", gpa=" + gpa + '\'' +
                ", bestRewardName='" + bestRewardName + '\'' +
                '}';
    }
}
