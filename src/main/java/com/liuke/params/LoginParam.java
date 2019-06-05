package com.liuke.params;

import com.liuke.bases.BasePath;
import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

import java.util.HashMap;
import java.util.Iterator;

public class LoginParam extends AbstractParam {

    private HashMap<String ,String > maps = new HashMap<>();

    @Override public HashMap<String, String> getMaps() {
        return maps;
    }

    @Override public InterfaceEnum getInterfaceEnum() {
        return InterfaceEnum.LOGIN;
    }

    @Override public HashMap<String, String> getJsonMaps() {
        return null;
    }

    public void setMaps(HashMap<String, String> maps) {
        this.maps = maps;
    }



}
