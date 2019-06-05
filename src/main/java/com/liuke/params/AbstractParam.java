package com.liuke.params;

import com.liuke.bases.BasePath;
import com.liuke.bases.BaseRequestUrl;
import com.liuke.bases.InterfaceEnum;

import java.util.HashMap;

public abstract class AbstractParam extends BaseRequestUrl {

    protected BasePath basePath = new BasePath();

   public abstract HashMap<String,String > getMaps();
   public abstract InterfaceEnum getInterfaceEnum();
   public abstract HashMap<String,String > getJsonMaps();

    public StringBuilder requestURI(){
        StringBuilder sb = new StringBuilder(  );
        sb.append(buildInterface(getInterfaceEnum().getName()))
          .append(buildParams(getMaps()))
          .append(buildJsonParam(getMaps()));
        return sb;
    }

    public String requestURL(){

        StringBuilder sb = new StringBuilder();
        sb.append(basePath.buildBasePath())
          .append(requestURI());

        return sb.toString();
    }

}
