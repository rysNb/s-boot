package com.baizhi.service;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> selectAll(String department);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(Integer id);

    public Employee selectOne(Integer id);
}
