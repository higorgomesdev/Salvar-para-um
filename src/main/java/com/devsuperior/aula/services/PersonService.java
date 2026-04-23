package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.DTO.PersonDTO;
import com.devsuperior.aula.DTO.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
		
		Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
		
		//Department dept = new Department();
		//dept.setId(dto.getDepartment().getId());
		Person entity = new Person(null, dto.getName(), dto.getSalary(), dept);
		entity = repository.save(entity);
		
		return new PersonDepartmentDTO(entity);
	}
	
public PersonDTO insert(PersonDTO dto) {
		
		Department dept = departmentRepository.getReferenceById(dto.getDepartment());
		
		//Department dept = new Department();
		//dept.setId(dto.getDepartmentId();
		Person entity = new Person(null, dto.getName(), dto.getSalary(), dept);
		entity = repository.save(entity);
		
		return new PersonDTO(entity);
	}
}
