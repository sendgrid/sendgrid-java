package com.sendgrid.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.typechecker.TypeAsserts;
import com.sendgrid.typechecker.TypeCheckException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class TypeAssertsTest {
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void test_null_object_throws() throws TypeCheckException {
    Object o = null;
    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertNotNull("object", o);
  }

  @Test
  public void test_not_null_object_ok() throws TypeCheckException {
    Object o = new Object();
    TypeAsserts.assertNotNull("object", o);
  }

  @Test
  public void test_not_string_throws() throws TypeCheckException {
    JsonNode o = objectMapper.createObjectNode();
    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertString("id", false, o);
  }

  @Test
  public void test_required_null_string_throws() throws TypeCheckException {
    JsonNode o = null;
    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertString("id", true, o);
  }

  @Test
  public void test_not_required_null_string_ok() throws TypeCheckException {
    JsonNode o = null;
    TypeAsserts.assertString("id", false, o);
  }

  @Test
  public void test_parsed_value_is_string() throws TypeCheckException, IOException {
    String json = "{\"field\":\"string_value\"}";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertString("id", true, node.get("field"));
  }

  @Test
  public void test_parsed_number_is_ok() throws TypeCheckException, IOException {
    String json = "{\"field\":1200}";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertInteger("id", true, node.get("field"));
  }

  @Test
  public void test_too_big_int_throws() throws TypeCheckException, IOException {
    String json = "{\"field\":\"3000000000\"}";
    JsonNode node = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertInteger("id", true, node.get("field"));
  }

  @Test
  public void test_boolean_is_ok() throws TypeCheckException, IOException {
    String json = "{\"field\":true}";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertBoolean("id", true, node.get("field"));
  }

  @Test
  public void test_integer_as_boolean_is_not_ok() throws TypeCheckException, IOException {
    String json = "{\"field\":1}";
    JsonNode node = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertBoolean("id", true, node.get("field"));
  }

  @Test
  public void test_array_of_objects_is_ok() throws TypeCheckException, IOException {
    String json = "[{\"name\":\"John Doe\"}, {\"email\":\"john@doe.com\"}]";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertObjectArray("id", true, node);
  }

  @Test
  public void test_object_as_array_not_ok() throws TypeCheckException, IOException {
    String json = "{\"name\":\"John Doe\"}";
    JsonNode node = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertObjectArray("id", true, node);
  }

  @Test
  public void test_int_array_is_ok() throws TypeCheckException, IOException {
    String json = "[1, 2, 3, 4]";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertIntArray("id", true, node);
  }

  @Test
  public void test_string_array_is_not_int_array() throws TypeCheckException, IOException {
    String json = "[\"a\", \"b\", \"c\", \"d\"]";
    JsonNode node = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertIntArray("id", true, node);
  }

  @Test
  public void test_string_array_is_ok() throws TypeCheckException, IOException {
    String json = "[\"a\", \"b\", \"c\", \"d\"]";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertStringArray("id", true, node);
  }

  @Test
  public void test_int_array_is_not_string_array() throws TypeCheckException, IOException {
    String json = "[1, 2, 3, 4]";
    JsonNode node = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.assertStringArray("id", true, node);
  }

  @Test
  public void test_key_value_pairs_is_object_ok() throws TypeCheckException, IOException {
    String json = "{\"a\":\"a\", \"b\":\"b\", \"c\":\"c\", \"d\":\"d\"}";
    JsonNode node = objectMapper.readTree(json);

    TypeAsserts.assertObject("id", true, node);
  }

  @Test
  public void test_apply_asserts_on_object_ok() throws TypeCheckException, IOException {
    String json = "[{\"a\":\"a\", \"b\":\"b\"}, {\"a\":\"c\", \"b\":\"d\"}]";
    JsonNode root = objectMapper.readTree(json);

    TypeAsserts.applyAssertions((el) -> {
      JsonNode a = el.get("a");
      TypeAsserts.assertString("a", true, a);

      JsonNode b = el.get("b");
      TypeAsserts.assertString("b", true, b);
    }, root);
  }

  @Test
  public void test_apply_asserts_on_incorrect_object_not_ok() throws TypeCheckException, IOException {
    String json = "[{\"a\":\"a\", \"b\":\"b\"}, {\"a\":\"c\"}]";
    JsonNode root = objectMapper.readTree(json);

    thrown.expect(TypeCheckException.class);
    TypeAsserts.applyAssertions((el) -> {
      JsonNode a = el.get("a");
      TypeAsserts.assertString("a", true, a);

      JsonNode b = el.get("b");
      TypeAsserts.assertString("b", true, b);
    }, root);
  }

}
