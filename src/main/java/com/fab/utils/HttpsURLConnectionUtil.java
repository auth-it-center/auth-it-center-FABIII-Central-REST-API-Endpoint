package com.fab.utils;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

public class HttpsURLConnectionUtil {

    public static String executeGetRequest(String url, HashMap<String, String> headers) {

        try {
            //
            URL obj = new URL(url);
            //
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; utf-8");

            for (HashMap.Entry<String, String> entry : headers.entrySet()) {
                con.setRequestProperty(entry.getKey(), entry.getValue());
            }

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
