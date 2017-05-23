package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        URL url = new URL(args[1]);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);

        byte[] out = Files.readAllBytes(Paths.get(args[0]));
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "multipart/form-data; boundary=xYzZY");
        http.connect();
        try (OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
    }
}
