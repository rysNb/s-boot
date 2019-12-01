package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    public Admin selectBy(String name, String password);

    public void save(Admin admin);
}
