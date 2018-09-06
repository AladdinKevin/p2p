package com.xk.p2p.base.domain;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/6/5.
 */
public class SystemDictionaryItem extends BaseDomain {
    private Long    parentId;
    private String  title;
    private Integer sequence;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getJsonString(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("parentId",parentId);
        map.put("title",title);
        map.put("sequence",sequence);
        return JSON.toJSONString(map);
    }

}
