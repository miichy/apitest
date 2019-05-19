package com.liuke.params;

import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

public class OpenParam  extends BaseRequestUrl {

    public OpenParam(){
        super();
    }

    public OpenParam(String protocol,String serverName,int serverPort,String requestUri){
        super( protocol, serverName, serverPort, requestUri);
    }

    public void buildInterface(){
        buildInterface(InterfaceEnum.OPEN.getName());
    }

}
