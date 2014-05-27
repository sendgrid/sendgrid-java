package com.sendgrid;

import com.mashape.unirest.http.JsonNode;

public class SendGridResponse {

  private int code;
  private boolean success;
  private String message;


  public SendGridResponse(int code, JsonNode body) {
    this.code = code;
    this.success = code == 200 ? true : false;
    this.message = body.toString();
  }

  public int getCode() {
    return this.code;
  }

  public boolean getStatus() {
    return this.success;
  }

  public String getMessage() {
    return this.message;
  }

}
