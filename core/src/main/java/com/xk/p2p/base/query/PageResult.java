package com.xk.p2p.base.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/15.
 */
public class PageResult {
    private List<?> result;//当前页的结果集数据,查询得到
    private int     totalCount = 0;//总条数,查询得到

    private int currentPage = 1;//当前页码,用户传入
    private int pageSize    = 5;//每页最多显示条数,用户传入

    private int prevPage;//上一页,计算得到
    private int nextPage;//下一页,计算得到
    private int totalPage;//总页数,计算得到

    public int getTotalPage(){
        return totalCount==0?1:totalPage;
    }

    public PageResult(List<?> result, int totalCount, int currentPage, int pageSize){
        this.result = result;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        //---------------------------------
        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount /pageSize + 1;
        prevPage  = currentPage - 1 >= 1 ? currentPage - 1 : 1;
        nextPage  = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;
    }

    public static PageResult empty(int pageSize){
        return new PageResult(new ArrayList<>(),0,1,pageSize);
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
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

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
