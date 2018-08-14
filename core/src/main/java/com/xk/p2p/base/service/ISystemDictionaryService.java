package com.xk.p2p.base.service;

import com.xk.p2p.base.domain.SystemDictionary;
import com.xk.p2p.base.query.PageResult;
import com.xk.p2p.base.query.SystemDictionaryQueryObject;

/** 数据字典服务
 * Created by admin on 2018/7/12.
 */
public interface ISystemDictionaryService {

    /**
     * 数据字典的高级查询+分页
     * @param qo
     * @return
     */
    PageResult queryDics(SystemDictionaryQueryObject qo);

    /**
     * 保存,修改数据字典
     * @param dic
     */
    void saveOrUpdateDic(SystemDictionary dic);
}
