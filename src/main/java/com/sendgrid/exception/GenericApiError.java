package com.sendgrid.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;

@ToString
public class GenericApiError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<GenericError> errors;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    public GenericApiError() {
    }

    private GenericApiError(GenericApiError.Builder builder) {
        this.errors = builder.errors;
        this.id = builder.id;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<GenericError> errors;
        private String id;

        public Builder() {
        }

        public GenericApiError.Builder errors(List<GenericError> errors) {
            this.errors = errors;
            return this;
        }

        public GenericApiError.Builder id(String id) {
            this.id = id;
            return this;
        }

        public GenericApiError build() {
            return new GenericApiError(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GenericApiError.class.getSimpleName() + "(", ")");
        if (errors != null) joiner.add("errors=" + errors);
        if (id != null) joiner.add("id=" + id);
        return joiner.toString();
    }

} 