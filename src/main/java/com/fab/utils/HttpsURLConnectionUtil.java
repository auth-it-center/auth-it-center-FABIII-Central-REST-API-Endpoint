package com.fab.utils;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.HashMap;

public class HttpsURLConnectionUtil {

    public static String executeGetRequest(String url, HashMap<String, String> headers) {

        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (GeneralSecurityException e) {}

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
