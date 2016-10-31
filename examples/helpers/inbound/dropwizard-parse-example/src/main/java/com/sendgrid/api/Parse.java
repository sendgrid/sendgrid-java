package com.sendgrid.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parse {

    @JsonProperty
    private String envelope;

    public String getEnvelope() {
        return envelope;
    }

    public void setEnvelope(String envelope) {
        this.envelope = envelope;
    }
}
