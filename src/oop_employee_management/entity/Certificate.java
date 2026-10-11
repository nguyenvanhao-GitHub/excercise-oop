package oop_employee_management.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Certificate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String certificateId;
    private String certificateName;
    private String certificateRank;
    private LocalDate certificateDate;

    public Certificate() {
    }

    public Certificate(String certificateId, String certificateName, String certificateRank, LocalDate certificateDate) {
        this.certificateId = certificateId;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id='" + certificateId + '\'' +
                ", name='" + certificateName + '\'' +
                ", rank='" + certificateRank + '\'' +
                ", date=" + certificateDate +
                '}';
    }
}
