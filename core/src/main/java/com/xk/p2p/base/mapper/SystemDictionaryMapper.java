package com.xk.p2p.base.mapper;

import com.xk.p2p.base.domain.SystemDictionary;
import com.xk.p2p.base.query.SystemDictionaryQueryObject;

import java.util.List;

public interface SystemDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionary record);

    SystemDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKey(SystemDictionary record);

    int queryForCount(SystemDictionaryQueryObject qo);

    List<SystemDictionary> query(SystemDictionaryQueryObject qo);

    List<SystemDictionary> queryDicsListAll();
}