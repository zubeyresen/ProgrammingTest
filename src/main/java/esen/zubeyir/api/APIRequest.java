package esen.zubeyir.api;

import java.io.IOException;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:40
 */
public interface APIRequest {
    String get(String url, String query) throws IOException;
}
