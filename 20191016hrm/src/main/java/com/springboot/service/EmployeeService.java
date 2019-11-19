package com.springboot.service;

import com.springboot.bean.Employee;

import java.util.List;

public interface EmployeeService {
    /*查询所有的员工*/
    public List<Employee> find();

    /*添加员工功能*/
    public void add(Employee employee);

    /*删除功能*/
    public void delete(Integer id);

    /*模糊查询*/
    public List<Employee> selectEmployee(Employee employee);

    /*查询指定id的员工*/
    public Employee findById(Integer id);

    /*修改操作*/
    public void update(Employee employee);
}
