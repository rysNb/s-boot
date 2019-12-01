package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/selectBy")
    public String selectBy(String name, String password, HttpSession session) {
        Admin admin = adminService.selectBy(name, password);
        session.setAttribute("admin", admin);
        if (admin == null) {
            return "login";
        }
        return "redirect:/department/selectAll";
    }

    @RequestMapping("/save")
    public String save(Admin admin) {
        adminService.save(admin);
        return "login";
    }

}
