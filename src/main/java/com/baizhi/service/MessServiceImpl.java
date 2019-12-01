package com.baizhi.service;

import com.baizhi.dao.MessDao;
import com.baizhi.entity.mess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessServiceImpl implements MessService {
    @Autowired
    private MessDao messDao;


    @Override
    public void save(mess mess) {
        messDao.save(mess);
    }
}
