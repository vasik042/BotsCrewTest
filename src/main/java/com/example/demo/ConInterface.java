package com.example.demo;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Lector;
import com.example.demo.Services.DepartmentService;
import com.example.demo.Services.LectorService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConInterface {
    Scanner input;
    String inputText;

    public ConInterface(){
        input = new Scanner(System.in);
    }

    public void mainMenu(DepartmentService departmentService, LectorService lectorService){
        System.out.println("\nChoose command:\n" +
                "1. Who is head of department {department_name}.\n" +
                "2. Show {department_name} statistics.\n" +
                "3. Show the average salary for the department {department_name}.\n" +
                "4. Show count of employee for {department_name}.\n" +
                "5. Global search by {template}.\n");

        int number = input.nextInt();
        input.nextLine();

        if(number > 0 && number < 5){
            System.out.println("Type {department_name}:");
            inputText = input.nextLine();
        }else if (number == 5){
            System.out.println("Type {template}:");
            inputText = input.nextLine();
        }else {
            number = 0;
        }

        switch (number){
            case 1:
                one(departmentService);
                break;
            case 2:
                two(departmentService);
                break;
            case 3:
                three(departmentService);
                break;
            case 4:
                four(departmentService);
                break;
            case 5:
                five(lectorService);
                break;
            default:
                System.out.println("Try again");
        }
        mainMenu(departmentService, lectorService);
    }
    public void one(DepartmentService departmentService){
        Department department = departmentService.findByName(inputText);

        if (department != null){
            Lector head_of_department = department.getHead_of_department();
            System.out.println("Head of '" + department.getName() + "' department is " + head_of_department.getName());
        }else {
            System.out.println("Try again");
        }
    }

    public void two(DepartmentService departmentService){
        Department department = departmentService.findByName(inputText);

        if (department != null){
            Set<Lector> lectors = department.getLectors();

            int a = 0;
            int p = 0;
            int ap = 0;

            for (Lector l : lectors) {
                String degree = l.getDegree().getName();
                if (degree.equals("assistant")){
                    a++;
                }else if (degree.equals("professor")){
                    p++;
                }else {
                    ap++;
                }
            }
            System.out.println("assistans - "+ a +". \n" +
                    "associate professors - " + ap + "\n" +
                    "professors - " + p);
        }else {
            System.out.println("Try again");
        }
    }

    public void three(DepartmentService departmentService){
        Department department = departmentService.findByName(inputText);

        if (department != null){
            Set<Lector> lectors = department.getLectors();

            float averageSalary = 0;

            for (Lector l : lectors) {
                averageSalary += l.getSalary();
            }

            averageSalary /= lectors.size();

            System.out.println("The average salary of '" + department.getName() + "' is "+ averageSalary);
        }else {
            System.out.println("Try again");
        }
    }

    public void four(DepartmentService departmentService){
        Department department = departmentService.findByName(inputText);

        if (department != null){
            Set<Lector> lectors = department.getLectors();

            System.out.println("Employee count - " + lectors.size());
        }else {
            System.out.println("Try again");
        }
    }

    public void five(LectorService lectorService){
        List<Lector> all = lectorService.findAll();
        StringBuilder s = new StringBuilder();

        for (Lector l : all) {
            if (l.getName().contains(inputText)){
                s.append(l.getName()).append(" ");
            }
        }

        if (s.length() <= 0){
            System.out.println("No results");
        }else {
            System.out.println(s);
        }
    }
}
