package com.solr.data.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.solr.repository.Facet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.solr.data.model.Employee;
import com.solr.data.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@PostConstruct
	public void addEmployees() {
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee(1,"Tharun", "Bhel Nagar"));
		employees.add(new Employee(2,"Duggu", "3rd main"));
		employees.add(new Employee(3,"Devi", "Medavakkam"));
		repository.saveAll(employees);
	}
	
	@GetMapping("/getemployes")
	public Iterable<Employee> getEmployees(){
		return repository.findAll();
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		
		return repository.findByName(name);
		
	}
	
	@GetMapping("/getEmployeeByAddr/{name}")
	public Employee getEmployeeByAddr(@PathVariable String name) {
		return repository.findByAddress(name);
	}
	
}
