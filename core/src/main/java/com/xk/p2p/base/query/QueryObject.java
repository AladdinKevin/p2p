package com.xk.p2p.base.query;

/** 查询对象的基类
 * Created by admin on 2018/6/15.
 */
public class QueryObject {
    private int currentPage = 1;
    private int pageSize = 5;

    public int getStart(){
        return (currentPage - 1) * pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
