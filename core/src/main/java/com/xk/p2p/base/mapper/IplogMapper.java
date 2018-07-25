package com.xk.p2p.base.mapper;

import com.xk.p2p.base.domain.Iplog;
import com.xk.p2p.base.query.IplogQueryObject;

import java.util.List;

public interface IplogMapper {

    int insert(Iplog record);

    //========高级查询+分页
    /**
     * 查询符合条件的总条数
     */
    int queryForCount(IplogQueryObject qo);
    /**
     * 查询符合条件的数据
     */
    List<Iplog> query(IplogQueryObject qo);
}