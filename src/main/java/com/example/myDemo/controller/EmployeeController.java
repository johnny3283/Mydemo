package com.example.myDemo.controller;


import com.example.myDemo.entity.Employee;
import com.example.myDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {


    public EmployeeService employeeService;

    public  EmployeeController (EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

@GetMapping("/listEmployee")
public String listAllManager(Model theModel) {

    List<Employee> theManagers = employeeService.findAll();

    theModel.addAttribute("employees", theManagers);
    return "employees/listAllEmployee";
}

@GetMapping("/addEmployee")
    public  String addManager(Model theModel){

        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "employees/addEmployee";
}

@PostMapping("/saveEmployee")
    public String saveManager(@ModelAttribute ("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/listEmployee";
}

@PostMapping("/ShowOneEmployee")
    public String showOneManager(@RequestParam("employeeId") int theId , Model theModel){

    Employee theEmployee = employeeService.findById(theId);

    theModel.addAttribute("employee",theEmployee);

        return "employees/listOneEmployee";
}

}
