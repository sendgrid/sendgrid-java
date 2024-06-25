package com.sendgrid.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;

@ToString
public class GenericError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field")
    @Getter
    @Setter
    private String field;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("help")
    @Getter
    @Setter
    private Object help;

    public GenericError() {
    }

    private GenericError(GenericError.Builder builder) {
        this.message = builder.message;
        this.field = builder.field;
        this.help = builder.help;
    }

    // Builder class for constructing object
    public static class Builder {
        private String message;
        private String field;
        private Object help;

        public Builder() {
        }

        public GenericError.Builder message(String message) {
            this.message = message;
            return this;
        }

        public GenericError.Builder field(String field) {
            this.field = field;
            return this;
        }

        public GenericError.Builder help(Object help) {
            this.help = help;
            return this;
        }

        public GenericError build() {
            return new GenericError(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GenericError.class.getSimpleName() + "(", ")");
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        if (help != null) joiner.add("help=" + help);
        return joiner.toString();
    }

} 
    