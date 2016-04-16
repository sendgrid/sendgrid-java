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

    public SendGrid(String apiKey, Map<String,String> opts) {
        this(apiKey);
        if(opts.containsKey("host") == true) {
            this.host = opts.get("host");
        }
    }
    
    public String getVersion() {
        return this.VERSION;
    }
    
    public Response get(String endpoint) throws IOException {
        Request request = new Request();
        request.baseUri = host;
        request.requestHeaders = requestHeaders;
        request.method = Method.GET;
        request.endpoint = "/" + version + "/" + endpoint;
        Map<String,String> queryParams = new HashMap<String, String>();
        queryParams.put("limit", "100");
        queryParams.put("offset", "0");
        request.queryParams = queryParams;
        
        Response response = new Response();
        try {
            response = client.api(request);
        } catch (IOException ex) {
            throw ex;
        }
        return response;
    }
}
