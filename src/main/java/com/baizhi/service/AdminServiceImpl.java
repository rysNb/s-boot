package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin selectBy(String name, String password) {
        Admin admin = adminDao.selectBy(name, password);
        log.info("this is debug===>{}", admin);
        return admin;
    }

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);

    }
}
