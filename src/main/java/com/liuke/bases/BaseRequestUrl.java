package com.liuke.bases;

import java.util.HashMap;
import java.util.Iterator;

public class BaseRequestUrl {

    private String protocol = "http://";
    private String serverName = "www.baidu.com";
    private int serverPort = 80;
    private String requestUri = "/";

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

    protected void buildInterface(String interfaceName){
        StringBuilder sb = new StringBuilder();
        sb.append(interfaceName)
          .append("?");
        requestURL.append(sb);
    }

    protected void buildParams(HashMap<String ,String > maps){
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

    protected String getRequestURL(){
        return requestURL.toString();
    }

}
