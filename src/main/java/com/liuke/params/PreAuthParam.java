package com.liuke.params;

import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

import java.util.HashMap;

public class PreAuthParam extends BaseRequestUrl{

    private HashMap<String,String> maps = new HashMap<>();

    public HashMap<String, String> getMaps() {
        return maps;
    }

    public void setMaps(HashMap<String, String> maps) {
        this.maps = maps;
    }

    public PreAuthParam(){
        super();
    }

    public PreAuthParam(String protocol,String serverName,int serverPort,String requestUri){
        super( protocol, serverName, serverPort, requestUri);
    }

    private void buildInterface(){
        buildInterface(InterfaceEnum.PRE_AUTH.getName());
    }

    public String getURL(){
        buildInterface();
        if (maps != null){
            buildParams(maps);
        }
        System.out.println("===" +getRequestURL());
        return getRequestURL();
    }

}
