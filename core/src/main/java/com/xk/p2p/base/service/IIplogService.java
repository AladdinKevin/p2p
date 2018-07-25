package com.xk.p2p.base.service;

import com.xk.p2p.base.query.IplogQueryObject;
import com.xk.p2p.base.query.PageResult;

/**
 * Created by admin on 2018/6/15.
 */
public interface IIplogService {
    PageResult query(IplogQueryObject qo);
}
