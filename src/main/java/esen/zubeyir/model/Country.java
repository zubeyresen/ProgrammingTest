package esen.zubeyir.model;

import java.io.Serializable;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:30
 */
public class Country implements Serializable {
    private final String name;
    private final Long confirmed;
    private final Long recovered;
    private final Long deaths;

    public Country(String name, Long confirmed, Long recovered, Long deaths) {
        this.name = name;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public String getName() {
        return name;
    }

    public Long getConfirmed() {
        return confirmed;
    }

    public Long getRecovered() {
        return recovered;
    }

    public Long getDeaths() {
        return deaths;
    }
}
