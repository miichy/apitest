package com.liuke.end2end;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuke.entity.Account;
import com.liuke.params.LoginParam;
import com.liuke.params.PreAuthParam;
import com.liuke.requests.OpenRequest;
import com.liuke.requests.PreAuthRequest;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class AccountOpenAndLogin {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String doPreAuthRequest()throws IOException{
        PreAuthRequest mockRequest = mock(PreAuthRequest.class);

        HashMap<String ,String> params = new HashMap<>();
        params.put("account","00001");
        params.put("address","Beijing");
        params.put("token","!@#$%%");

        PreAuthParam preAuthParam = new PreAuthParam();
        preAuthParam.buildInterface();
        preAuthParam.buildParams(params);
        System.out.println(preAuthParam.getRequestURL());

        String jsonStr = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\",\"token\":\"jkldsafdsfjalfds\"}";

        Account account = objectMapper.readValue(jsonStr,Account.class);
        String accountStr = objectMapper.writeValueAsString(account);

        when(mockRequest.run(preAuthParam.getRequestURL())).thenReturn(accountStr);
        String response = mockRequest.run(preAuthParam.getRequestURL());
        System.out.println(response);

        return response;
    }

    public String getToken(String response) throws IOException {
        JsonNode node = objectMapper.readTree(response);
        System.out.println(node.get("name").asText());
        return node.get("name").asText();
    }

    public String doOpenRequest(String token) throws IOException {
        HashMap<String ,String> params = new HashMap<>();
        params.put("token",token);
        LoginParam loginParam = new LoginParam();
        loginParam.buildInterface();
//        loginParam.buildParams(params);
        String json = loginParam.buildJsonParam(params);

        System.out.println(loginParam.getRequestURL());
        System.out.println(json);

        OpenRequest openRequest = mock(OpenRequest.class);
        when(openRequest.post(loginParam.getRequestURL(),json)).thenReturn("SUCCESS");
        String response = openRequest.post(loginParam.getRequestURL(),json);
        System.out.println(response);
        return response;
    }

    public static void main(String[] args) throws IOException {
        AccountOpenAndLogin aa = new AccountOpenAndLogin();
        String response = aa.doPreAuthRequest();
        String openResponse = aa.doOpenRequest(aa.getToken(response));
        Assert.assertEquals(openResponse,"SUCCESS");

        //TODO use the preauth response to open and then login

    }

}
