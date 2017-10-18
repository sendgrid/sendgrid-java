package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class RawFileToBase64 {

  /**
   * You can use this method to encode a raw file to b64
   * @param  fileName    the name of the file to include
   * @throws IOException if the file wasnt processed correctly
   */
  public static String encodeFileToBase64Binary(String fileName) throws RuntimeException {
    File file = new File(fileName);
    try {
      byte[] bytes = loadFile(file);
    } catch (IOException e) {
      throw new RuntimeException("Unable to convert content stream to base 64 encoded string", e);
    }
    byte[] encoded = Base64.encodeBase64(bytes);
    String encodedString = new String(encoded);
    return encodedString;
  }
  /**
   * Read a raw file into a byte[].
   * @param  file        the file to read
   * @throws IOException if the file wasnt processed correctly
   */
  private static byte[] loadFile(File file) throws IOException {
    InputStream is = new FileInputStream(file);
    long length = file.length();
    
    /**
     * file too large?
     */
    if (length > Integer.MAX_VALUE) {
      throw new IOException("File is too large")
    }

    byte[] bytes = new byte[(int)length];
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length
           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
      offset += numRead;
    }
    if (offset < bytes.length) {
      throw new IOException("Could not completely read file " + fileName);
    }
    is.close();
    return bytes;
  }
}