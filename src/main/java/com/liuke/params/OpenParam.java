package com.liuke.params;

import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

import java.util.HashMap;

public class OpenParam  extends BaseRequestUrl {

    private HashMap<String,String> maps = new HashMap<>();

    public HashMap<String, String> getMaps() {
        return maps;
    }

    public void setMaps(HashMap<String, String> maps) {
        this.maps = maps;
    }

    public OpenParam(){
        super();
    }

    public OpenParam(String protocol,String serverName,int serverPort,String requestUri){
        super( protocol, serverName, serverPort, requestUri);
    }

    public void buildInterface(){
        buildInterface(InterfaceEnum.OPEN.getName());
    }

    public String buildJsonParam(){
       return buildJsonParam(maps);
    }

    public String getURL(){
        buildInterface();
        return getRequestURL();
    }
}
