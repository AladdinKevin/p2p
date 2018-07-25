package com.xk.p2p.base.service.impl;

import com.xk.p2p.base.domain.Iplog;
import com.xk.p2p.base.mapper.IplogMapper;
import com.xk.p2p.base.query.IplogQueryObject;
import com.xk.p2p.base.query.PageResult;
import com.xk.p2p.base.service.IIplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/6/15.
 */
@Service
public class IplogServiceImpl implements IIplogService {
    @Autowired
    private IplogMapper iplogMapper;
    @Override
    public PageResult query(IplogQueryObject qo) {
        int count = iplogMapper.queryForCount(qo);//总条数
        if (count > 0){
            List<Iplog> iplogList = iplogMapper.query(qo);//查询到的数据
            return new PageResult(iplogList,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }
}
