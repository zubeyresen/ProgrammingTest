package esen.zubeyir.utils;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:03
 */
public class Constants {

    public static final String CASES_URL    = "https://covid-api.mmediagroup.fr/v1/cases";
    public static final String VACCINES_URL = "https://covid-api.mmediagroup.fr/v1/vaccines";
    public static final String BACKUP_FILE_NAME = "backup.txt";

    public static String buildUrlWithQuery(String url, String query) {
        return url.concat("?country=").concat(query);
    }

    public static double calculatePercent(long part, long total) {
        return (double) (part * 100) / total;
    }

}
