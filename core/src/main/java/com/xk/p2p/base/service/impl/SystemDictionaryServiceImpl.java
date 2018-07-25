package com.xk.p2p.base.service.impl;

import com.sun.org.apache.xerces.internal.xs.LSInputList;
import com.xk.p2p.base.domain.SystemDictionary;
import com.xk.p2p.base.mapper.SystemDictionaryItemMapper;
import com.xk.p2p.base.mapper.SystemDictionaryMapper;
import com.xk.p2p.base.query.PageResult;
import com.xk.p2p.base.query.SystemDictionaryQueryObject;
import com.xk.p2p.base.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/7/12.
 */
@Service
public class SystemDictionaryServiceImpl implements ISystemDictionaryService {
    @Autowired
    private SystemDictionaryMapper dictionaryMapper;

    /**
     * 数据字典的高级查询+分页
     * @param qo
     * @return
     */
    @Override
    public PageResult queryDics(SystemDictionaryQueryObject qo) {
        int count = this.dictionaryMapper.queryForCount(qo);
        if (count > 0){
            List<SystemDictionary> list = this.dictionaryMapper.query(qo);
            return new PageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
        }else {
            return PageResult.empty(qo.getPageSize());
        }
    }
}
