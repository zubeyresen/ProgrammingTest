package esen.zubeyir.api;

import esen.zubeyir.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:40
 */

//Implementation of APIRequest interface
public class APIRequestImpl implements APIRequest {

    //In this method, we build get request with query param.
    //Returns json as string.
    @Override
    public String get(String url, String query) throws IOException {
        String urlStr = Constants.buildUrlWithQuery(url, query);
        URL connUrl = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) connUrl.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        StringBuilder responseStr = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseStr.append(inputLine);
            }
            in.close();
        }
        return responseStr.toString();
    }
}
