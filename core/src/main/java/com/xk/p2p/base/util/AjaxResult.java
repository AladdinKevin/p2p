package com.xk.p2p.base.util;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class AjaxResult {
    private boolean success;
    private String  msg;
    public AjaxResult(boolean success){
        this.success=success;
    }
    public AjaxResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
/*
* 失败
*/
    public AjaxResult(String msg) {
        super();
        this.success = false;
        this.msg = msg;
    }
}
