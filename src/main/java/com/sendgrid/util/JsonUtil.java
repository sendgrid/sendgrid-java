package com.sendgrid.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class for JSON serialization and deserialization using Jackson.
 * <p>
 * This class provides methods to convert Java objects to JSON strings and vice versa.
 * It includes a default {@link ObjectMapper} instance for common use cases,
 * while also allowing custom {@link ObjectMapper} instances for specific configurations.
 **/
public class JsonUtil {
    private static final ObjectMapper defaultObjectMapper = createDefaultObjectMapper();

    private static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public static String toJson(Object object) {
        return toJson(object, defaultObjectMapper);
    }

    /**
     * Converts an object to a JSON string using Jackson ObjectMapper.
     *
     * @param object the object to be converted to JSON
     * @param mapper the ObjectMapper instance
     * @return the JSON string representation of the object
     * @throws ApiException if there is a JSON processing or mapping error
     */
    public static String toJson(Object object, ObjectMapper mapper) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonMappingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (JsonProcessingException e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(InputStream json, Class<T> clazz) {
        return fromJson(json, defaultObjectMapper, clazz);
    }

    /**
     * Converts an InputStream to an object of the specified class using Jackson ObjectMapper.
     *
     * @param <T>          the type of the desired object
     * @param json         the InputStream containing JSON data
     * @param objectMapper the ObjectMapper instance
     * @param clazz        the Class object of the desired type
     * @return the object of type T
     * @throws ApiException           if there is a JSON parsing or mapping error
     * @throws ApiConnectionException if there is an I/O error
     */
    public static <T> T fromJson(final InputStream json, final ObjectMapper objectMapper, final Class<T> clazz) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    // Handle generic types such as List<AvailablePhoneNumber>
    public static <T> T fromJson(InputStream json, TypeReference<T> typeReference) {
        return fromJson(json, defaultObjectMapper, typeReference);
    }

    public static <T> T fromJson(InputStream json, ObjectMapper objectMapper, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
}
