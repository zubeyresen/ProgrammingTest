package esen.zubeyir.service;

import esen.zubeyir.model.Country;

import java.io.IOException;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 17:30
 */

//This is our service interface.
//There are 2 methods for 2 operations.
public interface ApiService {
    Country getCases(String query) throws IOException;
    Double getVaccinatedRate(String query) throws IOException;
}
