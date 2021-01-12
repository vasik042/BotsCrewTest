package com.example.demo;

import com.example.demo.Entities.Degree;
import com.example.demo.Entities.Department;
import com.example.demo.Entities.Lector;
import com.example.demo.Services.DegreeService;
import com.example.demo.Services.DepartmentService;
import com.example.demo.Services.LectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

		LectorService lectorService = (LectorService) applicationContext.getBean("lectorService");
		DegreeService degreeService = (DegreeService) applicationContext.getBean("degreeService");
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");

		Degree assistant = degreeService.addDegree(new Degree("assistant"));
		Degree associate_professor = degreeService.addDegree(new Degree("associate professor"));
		Degree professor = degreeService.addDegree(new Degree("professor"));


		Lector mike = new Lector("Mike", assistant, 400);
		Lector nike = new Lector("Nike", assistant, 410);
		Lector lake = new Lector("Lake", assistant, 420);
		Lector jake = new Lector("Jake", assistant, 430);
		Lector fake = new Lector("Fake", associate_professor, 600);
		Lector greg = new Lector("Greg", associate_professor, 610);
		Lector fred = new Lector("Fred", associate_professor, 620);
		Lector niko = new Lector("Niko", professor, 800);
		Lector rust = new Lector("Rust", professor, 810);

		Department first_department = new Department("First department", mike);
		Department second_department = new Department("Second department", nike);
		Department third_department = new Department("Third department", lake);

		mike.addDepartment(first_department);
		nike.addDepartment(second_department);
		lake.addDepartment(third_department);
		jake.addDepartment(first_department);
		fake.addDepartment(first_department);
		fake.addDepartment(second_department);
		greg.addDepartment(second_department);
		greg.addDepartment(third_department);
		fred.addDepartment(third_department);
		fred.addDepartment(second_department);
		niko.addDepartment(third_department);
		rust.addDepartment(third_department);
		rust.addDepartment(first_department);

		departmentService.addDepartment(first_department);
		departmentService.addDepartment(second_department);
		departmentService.addDepartment(third_department);

		lectorService.addLector(mike);
		lectorService.addLector(nike);
		lectorService.addLector(lake);
		lectorService.addLector(jake);
		lectorService.addLector(fake);
		lectorService.addLector(greg);
		lectorService.addLector(fred);
		lectorService.addLector(niko);
		lectorService.addLector(rust);

		ConInterface conInterface = new ConInterface();
		conInterface.mainMenu(departmentService, lectorService);

	}
}
