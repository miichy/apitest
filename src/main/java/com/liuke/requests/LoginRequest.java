package com.liuke.requests;

import com.liuke.params.LoginParam;
import okhttp3.*;

import java.io.IOException;

public class LoginRequest extends BaseRequest {

    private LoginParam loginParam;

    public LoginParam getLoginParam() {
        return loginParam;
    }

    public void setLoginParam(LoginParam loginParam) {
        this.loginParam = loginParam;
    }

    public String doRequest() throws IOException {
        String url = loginParam.requestURL();
        System.out.println("Login URL " + url);
        String response = get(url);
        return response;
    }
}
