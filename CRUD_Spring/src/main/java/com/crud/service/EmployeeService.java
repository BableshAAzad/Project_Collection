package com.crud.service;

import java.util.List;

import com.crud.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployee(Long employeeId);
	
	List<EmployeeDto> getAllEmployess();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
	
	void deleteEmplyee(Long employeeId);
}
