package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request) {
        List<Department> departments = departmentService.selectAll();
        HttpSession session = request.getSession();
        request.setAttribute("departments", departments);
        session.setAttribute("departments", departments);
        return "departments";
    }

    @RequestMapping("/selectOne")
    public String selectOne(Integer id, HttpServletRequest request) {
        Department department = departmentService.selectOne(id);
        request.setAttribute("department", department);
        return "updateDepartment";
    }

    @RequestMapping("/save")
    public String save(Department department) {

        departmentService.save(department);

        return "forward:selectAll";
    }

    @RequestMapping("/update")
    public String update(Department department) {
        departmentService.update(department);
        return "forward:selectAll";

    }

}
