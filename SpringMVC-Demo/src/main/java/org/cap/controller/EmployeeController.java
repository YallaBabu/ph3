package org.cap.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.cap.pojo.Employee;
import org.cap.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employeeForm")
	public String showEmployeeForm(ModelMap map){
		//Map<String, Object> map=new HashMap<>();
		map.put("emp", new Employee());
		map.put("deps", getAllDepartments());
		map.put("proj", getAllprojects());
    
		map.put("role", getAllroles());

		map.put("employees", employeeService.getAllEmployees());
		
		return "employee";
	}
	
	

	@RequestMapping(value="/empSave",method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("emp")Employee employee,
			BindingResult results,ModelMap map){
		//System.out.println(employee);
		map.put("deps", getAllDepartments());
		map.put("proj", getAllprojects());
	    
		map.put("role", getAllroles());


		
		map.put("employees", employeeService.getAllEmployees());
		
		if(results.hasErrors()){
			return "employee";
		}else{
		employeeService.saveEmployee(employee);
			return "redirect:employeeForm";
		}
	}
	
	
	
	public List<String> getAllDepartments(){
		List<String> departs=new ArrayList<>();
		departs.add("Select");
		departs.add("Sales");
		departs.add("Purchase");
		departs.add("Finance");
		departs.add("Marketing");
		departs.add("HR");
		departs.add("Training");
		return departs;
	}
	
	public List<String> getAllprojects(){	
		List<String> project=new ArrayList<>();
		project.add("Select");
		project.add("HSBC");
		project.add("Morgans Stanley");
		project.add("BarClays");
		project.add("IBM");
		project.add("ThoughtWorks");
		return project;
	}
	
	public List<String> getAllroles(){
		List<String> role=new ArrayList<>();
		role.add("Select");
		role.add("Developer");
        role.add("Tester");
        role.add("Manager");
        role.add("Team Leader");
		return role;
	}    
        
	
	
	
	
	@RequestMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer employeeId){
		employeeService.deleteEmployee(employeeId);
		return "redirect:/employeeForm";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
