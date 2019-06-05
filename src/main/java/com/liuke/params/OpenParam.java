package com.liuke.params;

import com.liuke.bases.InterfaceEnum;

import java.util.HashMap;

public class OpenParam  extends AbstractParam {

    private HashMap<String,String> maps = new HashMap<>();

    @Override public HashMap<String, String> getMaps() {
        return maps;
    }

    public void setMaps(HashMap<String, String> maps) {
        this.maps = maps;
    }

    @Override public InterfaceEnum getInterfaceEnum() {
        return InterfaceEnum.OPEN;
    }

    @Override public HashMap<String, String> getJsonMaps() {
        return maps;
    }

}
