package esen.zubeyir;

import esen.zubeyir.api.APIRequest;
import esen.zubeyir.api.APIRequestImpl;
import esen.zubeyir.service.ApiService;
import esen.zubeyir.service.ApiServiceImpl;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 11:58
 */
public class Main {
    public static void main(String[] args) {
        APIRequest api = new APIRequestImpl();
        ApiService service = new ApiServiceImpl(api);
        Application.getInstance(service).run();
    }
}