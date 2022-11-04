package esen.zubeyir.api;

import java.io.IOException;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:40
 */

//This interface created for api request.
//We are using only GET request for this application.
public interface APIRequest {

    //Get Method requires url and query parameter for '?country=<query>
    String get(String url, String query) throws IOException;
}
