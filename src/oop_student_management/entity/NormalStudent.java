package oop_student_management.entity;

import java.time.LocalDate;

public class NormalStudent extends Student{
    private int englishScore;
    private double entryTestScore;

    public NormalStudent() {
    }

    public NormalStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, int englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfor() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "NormalStudent{" +
                "fullName='" + getFullName() + '\'' +
                ", doB=" + getDoB() +
                ", sex='" + getSex() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", universityName='" + getUniversityName() + '\'' +
                ", gradeLevel='" + getGradeLevel() + '\'' +
                ", englishScore=" + englishScore + '\'' +
                ", entryTestScore=" + entryTestScore + '\'' +
                '}';
    }
}
