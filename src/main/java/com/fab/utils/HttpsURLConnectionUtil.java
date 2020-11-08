package com.fab.utils;


import com.fab.bailiff.lv.entity.BailiffLVResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpsURLConnectionUtil {

    public static String executeGetRequest(String url) {

        try {
            //
            URL obj = new URL(url);
            //
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");

            //
            int responseCode = con.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) { // success
                // input stream to String
                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader in = new BufferedReader(isr);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            }

        } catch (MalformedURLException e) {
            // TODO do something
            e.printStackTrace();
        } catch (ProtocolException e) {
            // TODO do something
            e.printStackTrace();
        } catch (IOException e) {
            // TODO do something
            e.printStackTrace();
        }


        return null;
    }

}
