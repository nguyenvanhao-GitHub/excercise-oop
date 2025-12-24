package oop_employee_management;

import java.time.LocalDate;

public class Certificate {
    private int CertificateID;
    private String CertificateName;
    private String CertificateRank;
    private LocalDate CertificateDate;

    public Certificate() {
    }

    public Certificate(int CertificateID, String CertificateName, String CertificateRank, LocalDate CertificateDate) {
        this.CertificateID = CertificateID;
        this.CertificateName = CertificateName;
        this.CertificateRank = CertificateRank;
        this.CertificateDate = CertificateDate;
    }

    public int getCertificateID() {
        return CertificateID;
    }

    public void setCertificateID(int certificateID) {
        CertificateID = certificateID;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        CertificateRank = certificateRank;
    }

    public LocalDate getCertificateDate() {
        return CertificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        CertificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "CertificateID=" + CertificateID +
                ", CertificateName='" + CertificateName + '\'' +
                ", CertificateRank='" + CertificateRank + '\'' +
                ", CertificateDate=" + CertificateDate +
                '}';
    }
}
