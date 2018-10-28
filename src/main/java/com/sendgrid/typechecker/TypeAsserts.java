package com.sendgrid.typechecker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TypeAsserts {

  /**
   * Call this method to check object not null.
   * @param fieldId id to be shown in exception log
   * @param value object to be checked
   * @throws RequiredFieldMissingException thrown if object is null
   */
  public static void assertNotNull(String fieldId,  Object value)
      throws RequiredFieldMissingException {
    if (value == null) {
      throw new RequiredFieldMissingException("Field: " + fieldId + " must not be null");
    }
  }

  /**
   * Call this method to check JsonNode is of type JsonNode.STRING.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if JsonNode is not of type JsonNode.STRING
   */
  public static void assertString(String fieldId,
                                  boolean isRequired,
                                   JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.STRING) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type String");
    }
  }

  /**
   * Call this method to check JsonNode is of type JsonNode.NUMBER.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if JsonNode is not of type JsonNode.NUMBER
   */
  public static void assertInteger(String fieldId,
                                   boolean isRequired,
                                    JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }

    if (value != null && value.getNodeType() != JsonNodeType.NUMBER) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Integer");
    }
  }

  /**
   * Call this method to check JsonNode is of type JsonNode.BOOLEAN.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if JsonNode is not of type JsonNode.BOOLEAN
   */
  public static void assertBoolean(String fieldId,
                                   boolean isRequired,
                                    JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.BOOLEAN) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Boolean");
    }
  }

  /**
   * Call this method to check JsonNode is of type JsonNode.OBJECT.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if JsonNode is not of type JsonNode.OBJECT
   */
  public static void assertObject(String fieldId,
                                  boolean isRequired,
                                   JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.OBJECT) {
      throw new TypeCheckException("Field: " + fieldId + " must be Object");
    }
  }

  /**
   * Call this method to check JsonNode is of type JsonNode.ARRAY.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if JsonNode is not of type JsonNode.ARRAY
   */
  public static void assertObjectArray(String fieldId,
                                       boolean isRequired,
                                        JsonNode value) throws TypeCheckException {
    if (isRequired) {
      assertNotNull(fieldId, value);
    }
    if (value != null && value.getNodeType() != JsonNodeType.ARRAY) {
      throw new TypeCheckException("Field: " + fieldId + " must be of type Array");
    }
  }

  /**
   * Call this method to check json array items are of type JsonNode.NUMBER.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if json array items are not of type JsonNode.NUMBER
   */
  public static void assertIntArray(String fieldId,
                                    boolean isRequired,
                                     JsonNode value) throws TypeCheckException {
    assertObjectArray(fieldId, isRequired, value);

    List<JsonNode> notIntNodes = StreamSupport.stream(value.spliterator(), false)
        .filter(new Predicate<JsonNode>() {
          @Override
          public boolean test(JsonNode el) {
            return el.getNodeType() != JsonNodeType.NUMBER;
          }
        })
        .collect(Collectors.<JsonNode>toList());

    if (!notIntNodes.isEmpty()) {
      throw new TypeCheckException("Field: " + fieldId + " contents must be of type Integer");
    }
  }

  /**
   * Call this method to check json array items are of type JsonNode.STRING.
   * @param fieldId id to be shown in exception log
   * @param isRequired if true object is checked for null
   * @param value node to be checked
   * @throws TypeCheckException thrown if json array items are not of type JsonNode.STRING
   */
  public static void assertStringArray(String fieldId,
                                       boolean isRequired,
                                        JsonNode value) throws TypeCheckException {
    assertObjectArray(fieldId, isRequired, value);

    if (value != null) {
      List<JsonNode> notIntNodes = StreamSupport.stream(value.spliterator(), false)
          .filter(new Predicate<JsonNode>() {
            @Override
            public boolean test(JsonNode el) {
              return el.getNodeType() != JsonNodeType.STRING;
            }
          })
          .collect(Collectors.<JsonNode>toList());

      if (!notIntNodes.isEmpty()) {
        throw new TypeCheckException("Field: " + fieldId + " contents must be of type String");
      }
    }
  }

  /**
   * Call this method to apply assertions on all json array items.
   * @param assertions assertions to be applied on node children
   * @param value node array container
   * @throws TypeCheckException thrown if any of json array items are not satisfying assertions
   */
  public static void applyAssertions(
       ThrowingConsumer<JsonNode, TypeCheckException> assertions,
       JsonNode value) throws TypeCheckException {
    final ThrowingConsumer<JsonNode, TypeCheckException> asserts = assertions;
    List<TypeCheckException> nodesCheckResult =
        StreamSupport.stream(value.spliterator(), true)
            .map(new Function<JsonNode, TypeCheckException>() {
              @Override
              public TypeCheckException apply(JsonNode el) {
                try {
                  asserts.accept(el);
                  return null;
                } catch (TypeCheckException ex) {
                  return ex;
                }
              }
            })
            .filter(new Predicate<TypeCheckException>() {
              @Override
              public boolean test(TypeCheckException obj) {
                return Objects.nonNull(obj);
              }
            })
            .collect(Collectors.<TypeCheckException>toList());

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
