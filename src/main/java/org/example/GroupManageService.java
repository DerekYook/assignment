package org.example;

import java.util.*;

public class GroupManageService {
//    private static Map<String, Department> departmentMap = new HashMap<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to the Department Management System!");
//
//        // Read department structure diagram
//        System.out.println("Enter the department structure diagram (format: [Parent Department] > [Sub Department]):");
//        while (true) {
//            String input = scanner.nextLine().trim();
//            if (input.isEmpty()) {
//                break;
//            }
//
//            String[] tokens = input.split(">");
//            if (tokens.length != 2) {
//                System.out.println("Invalid input format. Please use [Parent Department] > [Sub Department] format.");
//                continue;
//            }
//
//            String parentDepartment = tokens[0].trim();
//            String subDepartment = tokens[1].trim();
//
//            addSubDepartment(parentDepartment, subDepartment);
//        }
//
//        // Read department personnel information
//        System.out.println("Enter the department personnel information (format: [Department Name], [Number of Persons]):");
//        while (true) {
//            String input = scanner.nextLine().trim();
//            if (input.isEmpty()) {
//                break;
//            }
//
//            String[] tokens = input.split(",");
//            if (tokens.length != 2) {
//                System.out.println("Invalid input format. Please use [Department Name], [Number of Persons] format.");
//                continue;
//            }
//
//            String departmentName = tokens[0].trim();
//            int numPersons = Integer.parseInt(tokens[1].trim());
//
//            setDepartmentHeadcount(departmentName, numPersons);
//        }
//
//        // Calculate and display the total personnel for each top-level department
//        for (Department department : departmentMap.values()) {
//            if (department.isTopLevel()) {
//                int totalPersonnel = department.calculateTotalPersonnel();
//                System.out.println(department.getName() + ", " + totalPersonnel);
//            }
//        }
//    }
//
//    private static void addSubDepartment(String parentDepartment, String subDepartment) {
//        Department parent = getOrCreateDepartment(parentDepartment);
//        Department sub = getOrCreateDepartment(subDepartment);
//
//        parent.addSubDepartment(sub);
//    }
//
//    private static void setDepartmentHeadcount(String departmentName, int numPersons) {
//        Department department = getOrCreateDepartment(departmentName);
//        department.setHeadcount(numPersons);
//    }
//
//    private static Department getOrCreateDepartment(String departmentName) {
//        if (departmentMap.containsKey(departmentName)) {
//            return departmentMap.get(departmentName);
//        } else {
//            Department department = new Department(departmentName);
//            departmentMap.put(departmentName, department);
//            return department;
//        }
//    }
    public static void main(String[] args) {
        // 입력(부서인원정보) : 부서명 / 인원수
        // 입력(부서 구성도) : 상위>하위 (*>하위 : 최상위)
        // 출력 : 최상위 부서명, 총 인원
    }
}

//class Department {
//    private String name;
//    private int headcount;
//    private List<Department> subDepartments;
//
//    public Department(String name) {
//        this.name = name;
//        this.headcount = 0;
//        this.subDepartments = new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setHeadcount(int headcount) {
//        this.headcount = headcount;
//    }
//
//    public void addSubDepartment(Department subDepartment) {
//        subDepartments.add(subDepartment);
//    }
//
//    public boolean isTopLevel() {
//        return subDepartments.isEmpty();
//    }
//
//    public int calculateTotalPersonnel() {
//        int total = headcount;
//        for (Department subDepartment : subDepartments) {
//            total += subDepartment.calculateTotalPersonnel();
//        }
//        return total;
//    }
//}