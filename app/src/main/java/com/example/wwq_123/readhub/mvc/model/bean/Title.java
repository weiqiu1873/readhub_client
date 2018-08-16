package com.example.wwq_123.readhub.mvc.model.bean;

import java.io.Serializable;

public class Title implements Serializable{
    private String name;
    private String href;

    public Title(){}
    public Title(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
