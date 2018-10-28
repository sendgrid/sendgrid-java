package com.sendgrid.typechecker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TypeAsserts {

  public static void assertNotNull(@NotNull String fieldId, @Nullable Object value) throws RequiredFieldMissingException {
    if (value == null) {
      throw new RequiredFieldMissingException("Field: " + fieldId + " must not be null");
    }
  }

  public static void assertString(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.STRING) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type String");
    }
  }

  public static void assertInteger(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }

    if (value != null && value.getNodeType() != JsonNodeType.NUMBER) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Integer");
    }
  }

  public static void assertBoolean(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.BOOLEAN) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Boolean");
    }
  }

  public static void assertObject(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.OBJECT) {
      throw new TypeCheckException("Field: " + fieldId + " must be Object");
    }
  }

  public static void assertObjectArray(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.ARRAY) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Array");
    }
  }

  public static void assertIntArray(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    assertObjectArray(fieldId, isRequired, value);

    List<JsonNode> notIntNodes = StreamSupport.stream(value.spliterator(), false)
        .filter((el) -> el.getNodeType() != JsonNodeType.NUMBER)
        .collect(Collectors.toList());

    if (!notIntNodes.isEmpty()) {
      throw new TypeCheckException("Field: " + fieldId + " contents must be of type Integer");
    }
  }

  public static void assertStringArray(@NotNull String fieldId, boolean isRequired, @Nullable JsonNode value) throws TypeCheckException {
    assertObjectArray(fieldId, isRequired, value);

    if (value != null) {
      List<JsonNode> notIntNodes = StreamSupport.stream(value.spliterator(), false)
          .filter((el) -> el.getNodeType() != JsonNodeType.STRING)
          .collect(Collectors.toList());

      if (!notIntNodes.isEmpty()) {
        throw new TypeCheckException("Field: " + fieldId + " contents must be of type String");
      }
    }
  }

  public static void applyAssertions(@NotNull ThrowingConsumer<JsonNode, TypeCheckException> assertions, @NotNull JsonNode value) throws TypeCheckException {
    List<TypeCheckException> nodesCheckResult = StreamSupport.stream(value.spliterator(), true)
        .map((el) -> {
          try {
            assertions.accept(el);
            return null;
          } catch (TypeCheckException ex) {
            return ex;
          }
        })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());

    if (nodesCheckResult != null && !nodesCheckResult.isEmpty()) {
      throw nodesCheckResult.get(0);
    }
  }

  @FunctionalInterface
  public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
  }

  private TypeAsserts() {
  }
}
