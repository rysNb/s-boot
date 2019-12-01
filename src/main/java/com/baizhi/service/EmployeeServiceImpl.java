package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.EmployeeDao;
import com.baizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public List<Employee> selectAll(String department) {
        return employeeDao.selectAll(department);
    }

    @Log(name = "这是添加员工")
    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);

    }

    @Log(name = "这是修改员工")
    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);

    }

    @Log(name = "这是删除员工")
    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public Employee selectOne(Integer id) {
        return employeeDao.selectOne(id);
    }
}
