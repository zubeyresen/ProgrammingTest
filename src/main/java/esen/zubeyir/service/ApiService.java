package esen.zubeyir.service;

import esen.zubeyir.model.Country;

import java.io.IOException;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 17:30
 */
public interface ApiService {
    Country getCases(String query) throws IOException;
    Double getVaccinatedRate(String query) throws IOException;
}
