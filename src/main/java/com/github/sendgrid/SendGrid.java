package com.github.sendgrid;

import org.json.JSONObject;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendGrid {

  private String username;
  private String password;
  private String url;
  private int port;
  private String endpoint;

  public SendGrid(String username, String password) {
    this.username = username;
    this.password = password;
    this.url = "https://api.sendgrid.com";
    this.port = 447;
    this.endpoint = "/api/mail.send.json";
  }

  public SendGrid setUrl(String url) {
    this.url = url;
    return this;
  }

  public SendGrid setPort(int port) {
    this.port = port;
    return this;
  }

  public SendGrid setEndpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

  public void send(Mail mail) throws UnirestException {
    HttpResponse<JsonNode> response = Unirest.post(this.url + ":" + this.port + this.endpoint)
    .fields(mail.buildBody()).field("api_user", this.username).field("api_key", this.password).asJson();
  }

}
