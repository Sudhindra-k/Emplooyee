package sudhi.thymeleaf.emplooyee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sudhi.thymeleaf.emplooyee.entity.Employee;
import sudhi.thymeleaf.emplooyee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService empservice;

	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
	}
	
	//add mapping for list
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Employee> emp = empservice.findall();
		
		model.addAttribute("employees", emp);
		
		return "list-employees";
		
	}
	
	@GetMapping("/showform")
	public String addemployee(Model model) {
		
		Employee emp = new Employee();
		
		model.addAttribute("employee", emp);
		
		return "form";
		
	}
	
	@GetMapping("/updateform")
	public String updateemployee(@RequestParam("employeeId") int id, Model model) {
		
		Employee emp = empservice.findbyId(id);
		
		model.addAttribute("employee", emp);
		
		return "form";
		
	}
	
	@GetMapping("/deleteEmp")
	public String deleteemployee(@RequestParam("employeeId") int id) {
		
		empservice.deletebyId(id);
		
		return "redirect:/employees/list";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee emp) {
		
		empservice.save(emp);
		
		return "redirect:/employees/list";
		
	}
	
}
