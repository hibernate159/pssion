package com.l.z.dao.mapper;

import com.l.z.dao.pojo.user;
import com.l.z.dao.pojo.userKey;
import com.l.z.dao.pojo.userWithBLOBs;

public interface userMapper {
    int deleteByPrimaryKey(userKey key);

    int insert(userWithBLOBs record);

    int insertSelective(userWithBLOBs record);

    userWithBLOBs selectByPrimaryKey(userKey key);

    int updateByPrimaryKeySelective(userWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(userWithBLOBs record);

    int updateByPrimaryKey(user record);
}