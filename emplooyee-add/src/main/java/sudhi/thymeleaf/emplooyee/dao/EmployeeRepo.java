package sudhi.thymeleaf.emplooyee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sudhi.thymeleaf.emplooyee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
