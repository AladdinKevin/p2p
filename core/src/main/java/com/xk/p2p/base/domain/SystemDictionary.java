package com.xk.p2p.base.domain;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/6/5.
 */
public class SystemDictionary extends BaseDomain {
    private String sn;
    private String title;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJsonString(){
        Map<String,Object> json = new HashMap<>();
        json.put("id", id);
        json.put("sn",sn);
        json.put("title",title);
        return JSON.toJSONString(json);
    }

}
