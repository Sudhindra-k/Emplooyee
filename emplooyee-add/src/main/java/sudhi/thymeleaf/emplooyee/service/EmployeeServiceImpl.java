package sudhi.thymeleaf.emplooyee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sudhi.thymeleaf.emplooyee.dao.EmployeeRepo;
import sudhi.thymeleaf.emplooyee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepo emprepo;
	
	public EmployeeServiceImpl(EmployeeRepo emprepo) {
		this.emprepo = emprepo;
	}

	@Override
	public List<Employee> findall() {
		return emprepo.findAll();
	}

	@Override
	public Employee findbyId(int id) {

		Optional<Employee> result = emprepo.findById(id);
		
		Employee emp = null;
		
		if(result.isPresent())
		{
			emp = result.get();
		}
		else
		{
			throw new RuntimeException("Did not find employee id - "+id);
		}
		
		return emp;
	}

	@Override
	public void save(Employee emp) {
	
		emprepo.save(emp);

	}

	@Override
	public void deletebyId(int id) {

		emprepo.deleteById(id);

	}

}
