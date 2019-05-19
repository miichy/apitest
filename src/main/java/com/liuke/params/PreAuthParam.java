package com.liuke.params;

import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

public class PreAuthParam extends BaseRequestUrl{

    public PreAuthParam(){
        super();
    }

    public PreAuthParam(String protocol,String serverName,int serverPort,String requestUri){
        super( protocol, serverName, serverPort, requestUri);
    }

    public void buildInterface(){
        buildInterface(InterfaceEnum.PRE_AUTH.getName());
    }

}
