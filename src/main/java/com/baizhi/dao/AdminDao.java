package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    public Admin selectBy(@Param("name") String name, @Param("password") String password);

    public void save(Admin admin);
}
