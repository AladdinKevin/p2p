package com.xk.p2p.base.mapper;

import com.xk.p2p.base.domain.Logininfo;
import org.apache.ibatis.annotations.Param;

public interface LogininfoMapper {

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Logininfo record);

    Long selectCountByUsername(String username);

    Logininfo login(@Param("username") String username,@Param("password") String encode,@Param("userType")int userType);

    int selectCountByUserType(int userType);
}