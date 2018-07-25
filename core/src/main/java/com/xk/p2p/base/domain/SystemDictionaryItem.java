package com.xk.p2p.base.domain;

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
}
