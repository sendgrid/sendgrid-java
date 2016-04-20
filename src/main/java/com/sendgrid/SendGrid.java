package com.sendgrid;

import com.sendgrid.Client;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;

import java.io.*;
import java.util.*;

public class SendGrid {
    private static final String VERSION = "3.0.0";
    private static final String USER_AGENT = "sendgrid/" + VERSION + ";java";
    
    private String apiKey;
    private String host;
    private String version;
    private Client client;
    private Map<String,String> requestHeaders;

    public SendGrid(String apiKey) {
        this.apiKey = apiKey;
        this.host = "api.sendgrid.com";
        this.version = "v3";
        this.client = new Client();
        this.requestHeaders = new HashMap<String, String>();
        this.requestHeaders.put("Authorization", "Bearer " + apiKey);
        this.requestHeaders.put("Content-Type", "application/json");
        this.requestHeaders.put("User-agent", USER_AGENT);
    }

    public String getVersion() {
        return this.VERSION;
    }
    
    public Map<String,String> addHeader(String key, String value){
        this.requestHeaders.put(key, value); 
        return this.requestHeaders;
    }
    
    public Map<String,String> removeHeader(String key){
        this.requestHeaders.remove(key); 
        return this.requestHeaders;
    }
    
    public void setHost(String host){
        this.host = host;
    }
    
    public void setVersion(String version){
        this.version = version;
    }
    
    public Response api(Request request) throws IOException {
        Request req = new Request();
        req.method = request.method;
        req.baseUri = this.host;
        req.endpoint = "/" + version + "/" + request.endpoint;
        req.requestBody = request.requestBody;
        req.requestHeaders = this.requestHeaders;
        req.queryParams = request.queryParams;
        
        Response response = new Response();
        try {
            response = client.api(req);
        } catch (IOException ex) {
            throw ex;
        }
        return response;
    }
}
