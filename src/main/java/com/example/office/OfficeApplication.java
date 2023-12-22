package com.example.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.office.model.Department;
import com.example.office.model.Employee;
import com.example.office.model.Project;
import com.example.office.repository.DepartmentRepository;
import com.example.office.repository.EmployeeRepository;
import com.example.office.repository.ProjectRepository;


@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(OfficeApplication.class);
	private final DepartmentRepository departmentRepository;
	private final EmployeeRepository employeeRepository;
	private final ProjectRepository projectRepository;

	



	public OfficeApplication(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository,
			ProjectRepository projectRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Department dept1 = new Department("Accounting");
		Department dept2 = new Department("Financial");
		Department dept3 = new Department("Purchasing");
		departmentRepository.saveAll(Arrays.asList(dept1, dept2 , dept3));

		Project proj1 = new Project("Project A");
		Project proj2 = new Project("Project B");
		projectRepository.saveAll(Arrays.asList(proj1, proj2));

		employeeRepository.save(new Employee("IN", 50000, dept1, proj1));
		employeeRepository.save(new Employee("RJ", 45000, dept1, proj2));
		employeeRepository.save(new Employee("YJ", 30000, dept2, proj1));
		employeeRepository.save(new Employee("YY", 20000, dept3, proj2));
		employeeRepository.save(new Employee("JK", 10000, dept3, proj1));

		for(Employee employee : employeeRepository.findAll()){
			logger.info("name: {}, salary:{}", employee.getName(), employee.getSalary());
		}

		for(Employee employee : employeeRepository.findByName("IN")){
			logger.info("name: {}, salary:{}", employee.getName(), employee.getSalary());
		}

		for(Employee employee : employeeRepository.findBySalaryGreaterThan(25000)){
			logger.info("name: {}, salary:{}", employee.getName(), employee.getSalary());
		}

		for(Project project : projectRepository.findByNameContaining("A")){
			logger.info("name: {}", project.getName());
		}

	}





}
