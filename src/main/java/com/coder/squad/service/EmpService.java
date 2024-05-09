package com.coder.squad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.squad.model.Employee;
import com.coder.squad.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	private EmpRepository repo;

	public Integer saveemp(Employee emp) {
		Employee save = repo.save(emp);

		return save.getId();
		// TODO Auto-generated method stub

	}

	public List<Employee> getAll() {
		List<Employee> findAll = repo.findAll();
		return findAll;
		
		// TODO Auto-generated method stub
		
	}

}
