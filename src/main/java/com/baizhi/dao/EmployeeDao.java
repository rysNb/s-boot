package com.baizhi.dao;

import com.baizhi.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> selectAll(String department);

    public Employee selectOne(Integer id);

    public void save(Employee employee);

    public void update(Employee employee);

    public void delete(Integer id);
}
