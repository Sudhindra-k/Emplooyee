package sudhi.thymeleaf.emplooyee.service;

import java.util.List;

import sudhi.thymeleaf.emplooyee.entity.Employee;

public interface EmployeeService {

	public List<Employee> findall();
	
	public Employee findbyId(int id);
	
	public void save(Employee emp);
	
	public void deletebyId(int id);
}
