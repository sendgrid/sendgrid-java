package com.sendgrid.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.typechecker.TypeCheckException;
import com.sendgrid.typechecker.TypeChecker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class TypeCheckerTest {
  private final ObjectMapper objectMapper = new ObjectMapper();
  private final TypeChecker typeChecker = new TypeChecker();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void test_example_ok() throws TypeCheckException, IOException {
    String json = "{\n" +
        "  \"personalizations\": [\n" +
        "    {\n" +
        "      \"to\": [\n" +
        "        {\n" +
        "          \"email\": \"john.doe@example.com\",\n" +
        "          \"name\": \"John Doe\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"subject\": \"Hello, World!\"\n" +
        "    }\n" +
        "  ],\n" +

        "  \"from\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"reply_to\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"content\": [\n" +
        "    {\n" +
        "      \"type\": \"text/plain\",\n" +
        "      \"value\": \"Hello, World!\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";

    typeChecker.checkMailParams(json);
  }

  @Test
  public void test_no_personalizations_error() throws TypeCheckException, IOException {
    String json = "{\n" +
        "  \"from\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"reply_to\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"content\": [\n" +
        "    {\n" +
        "      \"type\": \"text/plain\",\n" +
        "      \"value\": \"Hello, World!\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";

    thrown.expect(TypeCheckException.class);
    typeChecker.checkMailParams(json);
  }

  @Test
  public void test_wrong_type_send_at_error() throws TypeCheckException, IOException {
    String json = "{\n" +
        "  \"personalizations\": [\n" +
        "    {\n" +
        "      \"to\": [\n" +
        "        {\n" +
        "          \"email\": \"john.doe@example.com\",\n" +
        "          \"name\": \"John Doe\"\n" +
        "        }\n" +
        "      ],\n" +
        "      \"subject\": \"Hello, World!\",\n" +
        "      \"send_at\": \"Hello, World!\"\n" +
        "    }\n" +
        "  ],\n" +

        "  \"from\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"reply_to\": {\n" +
        "    \"email\": \"sam.smith@example.com\",\n" +
        "    \"name\": \"Sam Smith\"\n" +
        "  },\n" +
        "  \"content\": [\n" +
        "    {\n" +
        "      \"type\": \"text/plain\",\n" +
        "      \"value\": \"Hello, World!\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";

    thrown.expect(TypeCheckException.class);
    typeChecker.checkMailParams(json);
  }


}
