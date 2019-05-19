package com.liuke.bases;

import com.liuke.requests.BaseRequest;

import java.util.HashMap;
import java.util.Iterator;

public class BaseRequestUrl {

    private String protocol = "http://";
    private String serverName = "127.0.0.1";
    private int serverPort = 80;
    private String requestUri = "/liuke/apitest/";

    private StringBuilder requestURL = new StringBuilder();

    private void buildBase(){
        requestURL.append(protocol)
                  .append(serverName)
                  .append(":")
                  .append(serverPort)
                  .append(requestUri);
    }

    public BaseRequestUrl(){
        buildBase();
        System.out.println("********** initial requestURL: ***** " + requestURL.toString());
    }

    public BaseRequestUrl(String protocol,String serverName,int serverPort,String requestUri){
        this.protocol = protocol;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.requestUri = requestUri;
        buildBase();
        System.out.println("********** initial requestURL: ***** " + requestURL.toString());
    }

    public void buildInterface(String interfaceName){
        requestURL.append(interfaceName)
                  .append("?");
    }

    public void buildParams(HashMap<String ,String > maps){
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
        requestURL.append(sb);
    }

    private String wrapWithQuotation(String str){
        str = "\"" + str + "\"";
        return str;
    }

    public String buildJsonParam(HashMap<String,String> maps){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        maps.keySet().stream().forEach(key -> sb.append(wrapWithQuotation(key) + ":" + wrapWithQuotation(maps.get(key)) + "," ));
        sb.append("}");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public String getRequestURL(){
        return requestURL.toString();
    }

}
