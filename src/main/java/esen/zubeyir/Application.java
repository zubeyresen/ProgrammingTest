package esen.zubeyir;

import esen.zubeyir.io.FileOperations;
import esen.zubeyir.model.Country;
import esen.zubeyir.service.ApiService;
import esen.zubeyir.utils.Constants;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author zubeyresen
 * @version 1.0
 * created on 30/10/2022 - 12:33
 */
public class Application {

    private static Application instance = null;
    private final ApiService service;

    private Application(ApiService service) {
        this.service = service;
    }

    public static Application getInstance(ApiService service) {
        if (instance == null)
            instance = new Application(service);

        return instance;
    }

    /*
    On run method, applications asks for a country name.
    Country name is case sensitive, so user should enter correct form. (Only first letter must be uppercase)
    Calls getCases from service, writes results to console and stores for future usages.
    Then calls getVaccines from service and writes to console.

    If user fetching cases for the first time, application does not shows 'New cases since last data available'.

    IMPORTANT NOTE: vaccines endpoint is broken. So application writes 'broken endpoint' error.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter country: ");
        String country = sc.nextLine().trim();
        try {
            System.out.println("Fetching cases...");
            Country response = service.getCases(country);
            System.out.println("Confirmed cases: " + response.getConfirmed());
            System.out.println("Recovered: " + response.getRecovered());
            System.out.println("Deaths: " + response.getDeaths());

            HashMap<String, Long> backupData = (HashMap<String, Long>) FileOperations.getInstance().readFile(Constants.BACKUP_FILE_NAME);

            if (backupData != null ) {
                long lastCases = backupData.get(response.getName()) != null ? response.getConfirmed() : 0;
                System.out.println("New confirmed cases since last data available: " + (response.getConfirmed() - lastCases));
                backupData.put(response.getName(), response.getConfirmed());
                FileOperations.getInstance().writeFile(backupData, Constants.BACKUP_FILE_NAME);
            } else {
                HashMap<String, Long> newData = new HashMap<>();
                newData.put(response.getName(), response.getConfirmed());
                FileOperations.getInstance().writeFile(newData, Constants.BACKUP_FILE_NAME);
            }
        } catch (Exception e) {
            System.err.println("Error on fetching cases! Wrong input or broken endpoint.");
        }

        try {
            System.out.println("Fetching vaccines...");
            double rate = service.getVaccinatedRate(country);
            System.out.println("vaccinated level in % of total population: " + rate);
        } catch (Exception e) {
            System.err.println("Error on fetching vaccines! Wrong input or broken endpoint.");
        }
    }
}
