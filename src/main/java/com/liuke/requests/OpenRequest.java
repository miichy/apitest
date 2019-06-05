package com.liuke.requests;

import com.liuke.params.OpenParam;

import java.io.IOException;

public class OpenRequest extends BaseRequest{

    private OpenParam openParam;

    public OpenRequest(){}

    public OpenParam getOpenParam() {
        return openParam;
    }

    public void setOpenParam(OpenParam openParam) {
        this.openParam = openParam;
    }

    public String doRequest() throws IOException {
        String url = openParam.requestURL();
        String json = openParam.buildJsonParam(openParam.getJsonMaps()).toString();
        String response = post(url,json);
        return response;
    }
}
