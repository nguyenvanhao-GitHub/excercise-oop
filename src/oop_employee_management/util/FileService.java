package oop_employee_management.util;

import oop_employee_management.entity.*;
import oop_employee_management.enums.EmployeeType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static final String FIELD_DELIMITER = "|";
    private static final String FIELD_REGEX = "\\|";

    // =========================================================================
    // 1. ĐỌC / GHI FILE VĂN BẢN (.TXT) - CÓ BẮT LỖI TỪNG DÒNG
    // =========================================================================

    public static void saveEmployeesToTextFile(String filePath, List<Employee> employees) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            // Ghi header chú thích
            writer.write("# FORMAT: TYPE|ID|FULLNAME|BIRTHDAY|PHONE|EMAIL|EXTRA1|EXTRA2|[EXTRA3]|CERTIFICATES(id#name#rank#date;...)");
            writer.newLine();

            for (Employee emp : employees) {
                StringBuilder line = new StringBuilder();
                line.append(emp.getEmployeeType()).append(FIELD_DELIMITER);
                line.append(emp.getId()).append(FIELD_DELIMITER);
                line.append(emp.getFullName()).append(FIELD_DELIMITER);
                line.append(emp.getBirthDay()).append(FIELD_DELIMITER);
                line.append(emp.getPhone()).append(FIELD_DELIMITER);
                line.append(emp.getEmail()).append(FIELD_DELIMITER);

                if (emp instanceof Experience exp) {
                    line.append(exp.getExpInYear()).append(FIELD_DELIMITER);
                    line.append(exp.getProSkill()).append(FIELD_DELIMITER);
                } else if (emp instanceof Fresher fresher) {
                    line.append(fresher.getGraduationDate()).append(FIELD_DELIMITER);
                    line.append(fresher.getGraduationRank()).append(FIELD_DELIMITER);
                    line.append(fresher.getEducation()).append(FIELD_DELIMITER);
                } else if (emp instanceof Intern intern) {
                    line.append(intern.getMajors()).append(FIELD_DELIMITER);
                    line.append(intern.getSemester()).append(FIELD_DELIMITER);
                    line.append(intern.getUniversityName()).append(FIELD_DELIMITER);
                }

                // Certificates
                List<Certificate> certs = emp.getCertificates();
                if (certs == null || certs.isEmpty()) {
                    line.append("NONE");
                } else {
                    List<String> certStrings = new ArrayList<>();
                    for (Certificate c : certs) {
                        certStrings.add(c.getCertificateId() + "#" +
                                c.getCertificateName() + "#" +
                                c.getCertificateRank() + "#" +
                                c.getCertificateDate());
                    }
                    line.append(String.join(";", certStrings));
                }

                writer.write(line.toString());
                writer.newLine();
            }
        }
    }

    public static List<Employee> readEmployeesFromTextFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File không tồn tại: " + filePath);
        }

        List<Employee> employees = new ArrayList<>();
        int lineNumber = 0;
        int errorCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                try {
                    String[] parts = line.split(FIELD_REGEX, -1);
                    if (parts.length < 7) {
                        throw new IllegalArgumentException("Dòng không đủ số cột tối thiểu!");
                    }

                    EmployeeType type = EmployeeType.valueOf(parts[0].trim());
                    String id = parts[1].trim();
                    String fullName = parts[2].trim();
                    LocalDate birthDay = LocalDate.parse(parts[3].trim());
                    String phone = parts[4].trim();
                    String email = parts[5].trim();

                    Employee emp = null;

                    if (type == EmployeeType.EXPERIENCE && parts.length >= 9) {
                        int expInYear = Integer.parseInt(parts[6].trim());
                        String proSkill = parts[7].trim();
                        List<Certificate> certs = parseCertificates(parts[8].trim());
                        emp = new Experience(id, fullName, birthDay, phone, email, certs, expInYear, proSkill);
                    } else if (type == EmployeeType.FRESHER && parts.length >= 10) {
                        LocalDate gradDate = LocalDate.parse(parts[6].trim());
                        String gradRank = parts[7].trim();
                        String education = parts[8].trim();
                        List<Certificate> certs = parseCertificates(parts[9].trim());
                        emp = new Fresher(id, fullName, birthDay, phone, email, certs, gradDate, gradRank, education);
                    } else if (type == EmployeeType.INTERN && parts.length >= 10) {
                        String majors = parts[6].trim();
                        String semester = parts[7].trim();
                        String university = parts[8].trim();
                        List<Certificate> certs = parseCertificates(parts[9].trim());
                        emp = new Intern(id, fullName, birthDay, phone, email, certs, majors, semester, university);
                    }

                    if (emp != null) {
                        employees.add(emp);
                    } else {
                        System.err.println(">> [Cảnh báo - Dòng " + lineNumber + "]: Dữ liệu không khớp loại nhân viên!");
                        errorCount++;
                    }
                } catch (DateTimeParseException e) {
                    System.err.println(">> [Cảnh báo - Dòng " + lineNumber + "]: Sai định dạng ngày tháng (YYYY-MM-DD) -> Bỏ qua dòng.");
                    errorCount++;
                } catch (NumberFormatException e) {
                    System.err.println(">> [Cảnh báo - Dòng " + lineNumber + "]: Sai định dạng số -> Bỏ qua dòng.");
                    errorCount++;
                } catch (Exception e) {
                    System.err.println(">> [Cảnh báo - Dòng " + lineNumber + "]: Lỗi xử lý (" + e.getMessage() + ") -> Bỏ qua dòng.");
                    errorCount++;
                }
            }
        }

        if (errorCount > 0) {
            System.err.println(">> Đã bỏ qua " + errorCount + " dòng bị lỗi trong file text.");
        }
        return employees;
    }

    private static List<Certificate> parseCertificates(String certString) {
        List<Certificate> certs = new ArrayList<>();
        if (certString == null || certString.equalsIgnoreCase("NONE") || certString.trim().isEmpty()) {
            return certs;
        }

        String[] items = certString.split(";");
        for (String item : items) {
            String[] tokens = item.split("#", -1);
            if (tokens.length >= 4) {
                try {
                    String cId = tokens[0].trim();
                    String cName = tokens[1].trim();
                    String cRank = tokens[2].trim();
                    LocalDate cDate = LocalDate.parse(tokens[3].trim());
                    certs.add(new Certificate(cId, cName, cRank, cDate));
                } catch (Exception ignored) {
                }
            }
        }
        return certs;
    }

    // =========================================================================
    // 2. ĐỌC / GHI FILE NHỊ PHÂN (.DAT) - SERIALIZATION
    // =========================================================================

    public static void saveEmployeesToBinaryFile(String filePath, List<Employee> employees) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(new ArrayList<>(employees));
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> readEmployeesFromBinaryFile(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File không tồn tại: " + filePath);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?> list) {
                return (List<Employee>) list;
            }
            throw new IOException("Định dạng dữ liệu trong file nhị phân không hợp lệ!");
        }
    }
}
