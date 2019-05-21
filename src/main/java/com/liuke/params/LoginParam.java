package com.liuke.params;

import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

public class LoginParam extends BaseRequestUrl {

    public LoginParam(){
        super();
    }

    public LoginParam(String protocol,String serverName,int serverPort,String requestUri){
        super( protocol, serverName, serverPort, requestUri);
    }

    public void buildInterface(){
        buildInterface(InterfaceEnum.LOGIN.getName());
    }

    public String getURL(){
        buildInterface();
        System.out.println("===" +getRequestURL());
        return getRequestURL();
    }

}
