package com.liuke.requests;

import com.liuke.params.PreAuthParam;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

public class PreAuthRequest extends BaseRequest{

    public PreAuthRequest(){}

    private PreAuthParam param = new PreAuthParam();

    public PreAuthParam getParam() {
        return param;
    }

    public void setParam(PreAuthParam param) {
        this.param = param;
    }

    public String doRequest() throws IOException {
        String url = param.requestURL();
        String response = get(url);
        System.out.println(" do request response: "+ response);
        return response;
    }


}
