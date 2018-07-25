package com.xk.p2p.base.mapper;

import com.xk.p2p.base.domain.Userinfo;

public interface UserinfoMapper {

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Userinfo record);
}