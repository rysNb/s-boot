package com.baizhi.controller;

import com.baizhi.entity.Employee;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/selectAll")
    public String selectAll(String department, HttpServletRequest request) {
        List<Employee> employees = employeeService.selectAll(department);
        request.setAttribute("employees", employees);
        return "emplist";

    }

    @RequestMapping("/selectOne")
    public String selectOne(Integer id, HttpServletRequest request) {
        Employee employee = employeeService.selectOne(id);
        request.setAttribute("employee", employee);
        return "updateEmp";
    }

    @RequestMapping("save")
    public String save(Employee employee, MultipartFile aa, HttpServletRequest request) throws IOException {
        System.out.println("aa = " + aa);
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(realPath + "upload");
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println("aa = " + aa);
        String originalFilename = aa.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        aa.transferTo(new File(realPath + "/" + originalFilename));
        employee.setSrc(originalFilename);
        employeeService.save(employee);
        return "forward:/department/selectAll";
    }


    @RequestMapping("update")
    public String update(Employee employee, MultipartFile aa, HttpServletRequest request) {
        System.out.println("aa = " + aa);
        if (aa.getSize() != 0) {
            try {
                String realPath = request.getSession().getServletContext().getRealPath("/upload");
                String originalFilename = aa.getOriginalFilename();
                aa.transferTo(new File(realPath + "/" + originalFilename));
                employee.setSrc(originalFilename);
                System.out.println("修改后的图片" + originalFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            employee.setSrc(employee.getSrc());
        }
        employeeService.update(employee);
        return "forward:/department/selectAll";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        employeeService.delete(id);
        return "forward:/department/selectAll";
    }


}
