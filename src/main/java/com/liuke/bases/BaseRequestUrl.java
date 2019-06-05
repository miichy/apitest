package com.liuke.bases;

import java.util.HashMap;
import java.util.Iterator;

public class BaseRequestUrl {


    protected StringBuilder buildInterface(String interfaceName){
        StringBuilder sb = new StringBuilder();
        sb.append(interfaceName)
          .append("?");
        return sb;
    }

    protected StringBuilder buildParams(HashMap<String ,String > maps){
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = maps.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            sb.append(key)
              .append("=")
              .append(maps.get(key));
            if (it.hasNext()){
                sb.append("&");
            }
        }
        return sb;
    }

    private String wrapWithQuotation(String str){
        str = "\"" + str + "\"";
        return str;
    }

    public StringBuilder buildJsonParam(HashMap<String,String> maps){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        maps.keySet().stream().forEach(key -> sb.append(wrapWithQuotation(key) + ":" + wrapWithQuotation(maps.get(key)) + "," ));
        sb.append("}");
        System.out.println(sb.toString());
        return sb;
    }

}
