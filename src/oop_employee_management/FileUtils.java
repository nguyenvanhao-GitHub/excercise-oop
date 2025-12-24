package oop_employee_management;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtils {

    public static void wirteToFile(String path, EmployeeManager employeeManager, Class<?> type){

        List<Employee> filtered = employeeManager.getEmployees().stream().filter(type::isInstance).toList();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))){
            for (Employee employee : filtered) {
                bw.write(employee.toString());
                bw.flush();
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFromFile(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                String[] split = line.trim().split("[{,;}]");

               for (String s : split) {
                   System.out.println(s);
               }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
