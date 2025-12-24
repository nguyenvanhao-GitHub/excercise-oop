package oop_employee_management;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManage = new EmployeeManager();
        Scanner sc = new Scanner(System.in);

        Employee employee = null;

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Wirte To File");
            System.out.println("6. Read From File");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter Employee Id: ");
                        int id = sc.nextInt();

                        sc.nextLine();
                        System.out.println("Enter Employee Full Name: ");
                        String name = sc.nextLine();
                        Validator.validateName(name);

                        System.out.println("Enter Employee Birth Day: ");
                        String birthDay = sc.nextLine();
                        LocalDate validatedBirthday = Validator.validateBirthday(birthDay);

                        System.out.println("Enter Employee Phone Number: ");
                        String phoneNumber = sc.nextLine();
                        Validator.validatePhone(phoneNumber);

                        System.out.println("Enter Employee Email: ");
                        String email = sc.nextLine();
                        Validator.validateEmail(email);

                        System.out.println("Enter number of certificates: ");
                        int numberOfCertificates = sc.nextInt();

                        ArrayList<Certificate> certificates = new ArrayList<>();

                        for (int i = 0; i < numberOfCertificates; i++) {
                            System.out.println("Certificate: " + i);
                            System.out.println("Enter Certificate ID: ");
                            int certificateID = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter Certificate Name: ");
                            String certificateName = sc.nextLine();
                            System.out.println("Enter Certificate Rank: ");
                            String certificateRank = sc.nextLine();
                            System.out.println("Enter Certificate Date: ");
                            String certificateDate = sc.nextLine();
                            LocalDate certificateDateLD = Validator.validateBirthday(certificateDate);

                            certificates.add(new Certificate(certificateID, certificateName, certificateRank, certificateDateLD));
                        }




                        System.out.println("Enter Employee type: ");
                        Employee.Employee_type = sc.nextInt();

                        switch (Employee.Employee_type) {
                            case 1:
                                System.out.println("Enter Experience In Year: ");
                                int experienceInYear = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter Pro Skill: ");
                                String skill = sc.nextLine();
                                employee = new Experience(id, name, validatedBirthday, phoneNumber, email, certificates, experienceInYear, skill);
                                employeeManage.addEmployee(employee);
                                break;
                            case 2:
                                sc.nextLine();
                                System.out.println("Enter Graduation Date: ");
                                String graduationDate = sc.nextLine();
                                LocalDate validatedGraduation = Validator.validateBirthday(graduationDate);
                                System.out.println("Enter Graduation Rank: ");
                                String graduationRank = sc.nextLine();
                                System.out.println("Education: ");
                                String education = sc.nextLine();

                                employee = new Fresher(id, name, validatedBirthday, phoneNumber, email, certificates, validatedGraduation, graduationRank, education);
                                employeeManage.addEmployee(employee);
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.println("Enter Majors: ");
                                String majors = sc.nextLine();
                                System.out.println("Enter Semester: ");
                                String semester = sc.nextLine();
                                System.out.println("University Name: ");
                                String universityName = sc.nextLine();

                                employee = new Intern(id, name, validatedBirthday, phoneNumber, email, certificates, majors, semester, universityName);
                                employeeManage.addEmployee(employee);
                                break;

                        }
                        break;
                    } catch (BirthDayException | EmailException | FullNameException | PhoneException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                case 2:
                    employeeManage.showEmployees();
                    break;
                case 3:
                    System.out.println("Enter id to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Employee Full Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Employee Birth Day: ");
                    String birthDay = sc.nextLine();
                    LocalDate birthDated = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    System.out.println("Enter Employee Phone Number: ");
                    String phoneNumber = sc.nextLine();

                    System.out.println("Enter Employee Email: ");
                    String email = sc.nextLine();

                    employee = new Experience(id, name, birthDated, phoneNumber, email);
                    employee = new Fresher(id, name, birthDated, phoneNumber, email);
                    employee = new Intern( id, name, birthDated, phoneNumber, email);

                    employeeManage.updateEmployee(id, employee);
                    break;
                case 4:
                    System.out.println("Enter id to remove: ");
                    int ID = sc.nextInt();
                    sc.nextLine();
                    boolean isDeleted = employeeManage.deleteEmployee(ID);
                    if (isDeleted) {
                        System.out.println("Employee has been deleted");
                    } else{
                        System.out.println("Employee not found");
                    }
                    break;
                case 5:
                    FileUtils.wirteToFile("fresher.txt", employeeManage, Fresher.class );
                    FileUtils.wirteToFile("intern.txt", employeeManage,  Intern.class );
                    FileUtils.wirteToFile("experience.txt", employeeManage, Experience.class);
                    break;
                case 6:
                    FileUtils.readFromFile("employees.txt");
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}