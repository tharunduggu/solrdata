package com.solr.data.repository;

import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.solr.data.model.Employee;

public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer>{

	public Employee findByName(String name);
	
	
	@Facet(fields = {"name"})
	public Employee findByAddress(String name);
}
