package com.lesson5.lab_num5.util;

import javafx.scene.control.Alert;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Requests extends Thread {
    public String jsonIn;
    public static String url;

    private String readAll(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int cp;

        while ((cp = reader.read()) != -1) {
            builder.append((char) cp);
        }

        return builder.toString();
    }

    public String getDataFromConn() {
        jsonIn = "";
        InputStream inputStream = null;

        try {
            inputStream = new URL(url).openStream();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                try {
                    jsonIn = readAll(br);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (jsonIn.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid URL");
             alert.show();
        }
        return jsonIn;
    }

    @Override
    public void start() {
        getDataFromConn();
        super.start();
    }
}
