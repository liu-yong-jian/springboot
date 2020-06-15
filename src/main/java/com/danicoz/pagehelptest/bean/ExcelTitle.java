package com.danicoz.pagehelptest.bean;


import java.util.List;


public class ExcelTitle {

    private String name ;

    private Integer sort ;

    private Integer level ;

    private List<ExcelTitle> subTitle;

    public ExcelTitle(String name,Integer sort,Integer level){
        this.name = name;
        this.sort = sort;
        this.level =  level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<ExcelTitle> getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(List<ExcelTitle> subTitle) {
        this.subTitle = subTitle;
    }
}
