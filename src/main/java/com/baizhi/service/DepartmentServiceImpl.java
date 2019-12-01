package com.baizhi.service;

import com.baizhi.aspect.Log;
import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)

    @Override
    public Department selectOne(Integer id) {
        return departmentDao.selectOne(id);
    }

    @Log(name = "这是添加部门")
    @Override
    public void save(Department department) {
        departmentDao.save(department);

    }

    @Log(name = "这是修改部门")
    @Override
    public void update(Department department) {
        departmentDao.update(department);

    }
}
