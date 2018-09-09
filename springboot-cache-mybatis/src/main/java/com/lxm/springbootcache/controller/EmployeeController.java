package com.lxm.springbootcache.controller;

import com.lxm.springbootcache.bean.Employee;
import com.lxm.springbootcache.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee getOneEmp(@PathVariable("id") Integer id){
    return employeeService.getOneEmployee(id);
    }

    @GetMapping("/emp")
    public Employee updateOneEmp(Employee emp){
        return employeeService.updateOneEmp(emp);

    }

    @GetMapping("/del/{id}")
    public void deleteOneEmployee(@PathVariable("id") Integer id){
        employeeService.deleteOneEmployee(id);
    }

    @GetMapping("/emp/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name){
        return employeeService.getEmpByName(name);
    }
}
