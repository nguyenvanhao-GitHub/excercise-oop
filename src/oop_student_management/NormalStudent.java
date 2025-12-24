package oop_student_management;

import java.time.LocalDate;

public class NormalStudent extends Student{
    private double englishScore;
    private double entryTestScore;

    public NormalStudent() {
    }

    public NormalStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, double englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return super.toString() +
                "NormalStudent{" +
                "englishScore=" + englishScore +
                ", entryTestScore=" + entryTestScore +
                '}';
    }

    @Override
    public void ShowMyInfor() {
        System.out.println(this);
    }
}
