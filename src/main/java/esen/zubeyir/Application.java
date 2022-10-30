package esen.zubeyir;

import esen.zubeyir.model.Country;
import esen.zubeyir.service.ApiService;

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