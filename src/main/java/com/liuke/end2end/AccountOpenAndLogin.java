package com.liuke.end2end;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuke.entity.Account;
import com.liuke.params.LoginParam;
import com.liuke.params.OpenParam;
import com.liuke.params.PreAuthParam;
import com.liuke.requests.LoginRequest;
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
        preAuthParam.setMaps(params);
        mockRequest.setParam(preAuthParam);

        // test json function
        String jsonStr = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\",\"token\":\"jkldsafdsfjalfds\"}";
        Account account = objectMapper.readValue(jsonStr,Account.class);
        String accountStr = objectMapper.writeValueAsString(account);

        when(mockRequest.doRequest()).thenReturn(accountStr);
        String response = mockRequest.doRequest();
        System.out.println(response);

        return response;
    }

    public String getToken(String response) throws IOException {
        JsonNode node = objectMapper.readTree(response);
        System.out.println(node.get("token").asText());
        return node.get("token").asText();
    }

    public String doOpenRequest(String token) throws IOException {
        HashMap<String ,String> params = new HashMap<>();
        params.put("token",token);

        OpenParam openParam = new OpenParam();
        openParam.setMaps(params);

        OpenRequest openRequest = mock(OpenRequest.class);
        openRequest.setOpenParam(openParam);


        when(openRequest.doRequest()).thenReturn("SUCCESS");
        String response = openRequest.doRequest();
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
