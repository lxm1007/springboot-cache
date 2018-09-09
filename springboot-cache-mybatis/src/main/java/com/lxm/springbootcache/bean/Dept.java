package com.lxm.springbootcache.bean;

import java.io.Serializable;

public class Dept implements Serializable {

    private String deptname;
    private  Integer id;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
