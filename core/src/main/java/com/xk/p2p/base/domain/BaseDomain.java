package com.xk.p2p.base.domain;

import java.io.Serializable;

/**
 * Created by kevin on 2017/12/25.
 */
public class BaseDomain implements Serializable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
