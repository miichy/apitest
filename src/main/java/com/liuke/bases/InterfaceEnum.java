package com.liuke.bases;

import org.apache.commons.lang.StringUtils;

public enum InterfaceEnum {
    PRE_AUTH("s","the interface of PreAuth"),
    OPEN("open","the open interface"),
    LOGIN("login","the login interface");

    private String name = StringUtils.EMPTY;
    private String desc = StringUtils.EMPTY;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    InterfaceEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
