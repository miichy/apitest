package com.liuke.bases;

public class BasePath {

    private String scheme = "http";
    private String serverName = "www.baidu.com";
    private int serverPort = 80;
    private String contextPath = "/daniel/apitest/";

    public BasePath(){}

    public BasePath(String serverName,int serverPort){
        this("http",serverName,serverPort,"\"/daniel/apitest/\"");
    }

    public BasePath(String scheme,String serverName,int serverPort){
        this(scheme,serverName,serverPort,"\"/daniel/apitest/\"");
    }

    public BasePath(String scheme,String serverName,int serverPort,String contextPath){
        this.scheme = scheme;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.contextPath = contextPath;
    }

    public StringBuilder buildBasePath(){
        StringBuilder sb = new StringBuilder();
        sb.append(scheme)
          .append("://")
          .append(serverName)
          .append(":")
          .append(serverPort)
          .append(contextPath);
        return sb;
    }

}
