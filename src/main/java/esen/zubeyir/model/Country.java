package esen.zubeyir.model;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:30
 */
public class Country {
    private Long confirmed;
    private Long recovered;
    private Long deaths;

    public Country(Long confirmed, Long recovered, Long deaths) {
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
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
