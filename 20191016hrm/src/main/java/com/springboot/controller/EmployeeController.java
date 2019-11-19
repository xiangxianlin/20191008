package com.springboot.controller;

import com.springboot.bean.Employee;
import com.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*跳转到员工添加页面*/
    @RequestMapping("/emp/toAddEmp")
    public String toaddEmployee(){
        return "emp/addEmp";
    }

    /*添加功能*/
    @RequestMapping("employee/addEmp")
    public String addEmp(Employee employee){
        employeeService.add(employee);
        return "redirect:/emp/empList";
    }

    /*查询所有员工*/
    @RequestMapping("/emp/empList")
    public String empList(Model model){
        List<Employee> employees = employeeService.find();
        model.addAttribute("employees",employees);
        return "emp/empList";
    }

    /*删除功能*/
    @RequestMapping("emp/deleteEmp")
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/emp/empList";
    }

    /*模糊查询*/
    @RequestMapping("/employee/selectEmployee")
    public String selectEmployee(Employee employee,Model model){
        List<Employee> employees = employeeService.selectEmployee(employee);
        model.addAttribute("employees",employees);
        return "emp/empList";
    }



    /*跳转修改页面*/
    @RequestMapping("/emp/toUpdateEmp")
    public String toupdatePage(Integer id,Model model){
        /*查询指定id的员工把数据封装并跳转到修改页面*/
        Employee employee=employeeService.findById(id);
        model.addAttribute("emp",employee);
        return "emp/updateEmp";
    }

    /*修改操作*/
    @RequestMapping("/emp/updateEmp")
    public String update(Employee employee){
        employeeService.update(employee);
        return "redirect:/emp/empList";
    }
}
