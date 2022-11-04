package esen.zubeyir.service;

import esen.zubeyir.api.APIRequest;
import esen.zubeyir.model.Country;
import esen.zubeyir.utils.Constants;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 17:31
 */

//Implementation of service interface
public class ApiServiceImpl implements ApiService {

    APIRequest api;

    //Constructor injection used for injecting APIRequest
    public ApiServiceImpl(APIRequest api) {
        this.api = api;
    }

    //This method takes country name as query param.
    //Calls cases url with param and returns Country object.
    @Override
    public Country getCases(String query) throws IOException {
        String response = api.get(Constants.CASES_URL, query);
        JSONObject jsonObject = new JSONObject(response).getJSONObject("All");
        String name = jsonObject.getString("country");
        long confirmed = jsonObject.getLong("confirmed");
        long recovered = jsonObject.getLong("recovered");
        long deaths = jsonObject.getLong("deaths");
        return new Country(name, confirmed, recovered, deaths);
    }

    //This method takes country name as query param.
    //Calls vaccines url with query param and calculates rate of vaccines. Returns result as Double.
    @Override
    public Double getVaccinatedRate(String query) throws IOException {
        String response = api.get(Constants.VACCINES_URL, query);
        JSONObject jsonObject = new JSONObject(response).getJSONObject("All");
        long vaccinated = jsonObject.getLong("people_vaccinated");
        long population = jsonObject.getLong("population");
        return Constants.calculatePercent(vaccinated, population);
    }
}
