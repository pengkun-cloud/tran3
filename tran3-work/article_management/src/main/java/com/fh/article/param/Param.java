package com.fh.article.param;

public class Param {

    private Integer start;

    private Integer pageSize;

    @Override
    public String toString() {
        return "Param{" +
                "start=" + start +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
