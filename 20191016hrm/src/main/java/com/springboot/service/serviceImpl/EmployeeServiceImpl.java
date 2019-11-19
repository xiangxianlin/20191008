package com.springboot.service.serviceImpl;

import com.springboot.bean.Employee;
import com.springboot.mapper.EmployeeMapper;
import com.springboot.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /*查询所有的员工*/
    public List<Employee> find(){
        return employeeMapper.findUsers(null);
    }

    /*添加员工功能*/
    public void add(Employee employee){
        /*设置添加日期*/
        employee.setCreateDate(new Date());

        employeeMapper.add(employee);
    }

    /*删除功能*/
    public void delete(Integer id){
        employeeMapper.deleteById(id);
    }

    /*查询指定id的员工*/
    public Employee findById(Integer id){
        return employeeMapper.getUser(id);
    }

    /*模糊查询*/
    public List<Employee> selectEmployee(Employee employee){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotEmpty(String.valueOf(employee.getName()))){
            map.put("name","%"+employee.getName()+"%");
        }else if (StringUtils.isNotEmpty(employee.getPhone())){
            map.put("phone","%"+employee.getPhone()+"%");
        }else if (StringUtils.isNotEmpty(employee.getCardId())){
            map.put("cardId","%"+employee.getCardId()+"%");
        }else if (employee.getJob().getId()!=0){
            map.put("jobId",employee.getJob().getId());
        }
        else if (employee.getDept().getId()!=0){
            map.put("deptId",employee.getDept().getId());
        }else if (employee.getSex()!=0){
            map.put("sex",employee.getSex());
        }
        return  employeeMapper.findUsers(map);
    }

    /*修改操作*/
    public void update(Employee employee){
        employeeMapper.updateById(employee);
    }


}
