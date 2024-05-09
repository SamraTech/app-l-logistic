package com.coder.squad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coder.squad.model.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
