package com.xk.p2p.base.query;

import org.springframework.util.StringUtils;

/**数据字典查询对象
 * Created by admin on 2018/7/12.
 */
public class SystemDictionaryQueryObject extends QueryObject {

    private Integer parentId;
    private String keyword;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword(){
        return StringUtils.hasLength(keyword) ? keyword : null;
    }
}
