package com.goeuro.main;

import com.goeuro.helpers.CSVHelper;
import com.goeuro.helpers.CommandLineInfoHelper;
import com.goeuro.helpers.HttpHelper;
import com.goeuro.helpers.JsonHelper;
import com.goeuro.items.LocationInfoList;

import static com.goeuro.Constants.*;

/**
 * Created by hayk on 1/23/15.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(WELCOME_MSG);
        String cityName = "";
        if (args.length > 0) {
            cityName = args[0];
        }
        try (CommandLineInfoHelper.Cmd cmd = CommandLineInfoHelper.getCMD()) {
            while (cityName.isEmpty()) {
                cityName = cmd.read(READ_CITY_NAME_NOTIFICATION);
            }
            while (!cityName.equalsIgnoreCase(EXIT)) {
                process(cityName);
                cityName = cmd.read(READ_CITY_NAME_NOTIFICATION);
            }
        } catch (Exception e) {
            System.out.printf(CMD_READ_FAILURE_MSG, e.getMessage());
        }
    }

    private static void process(String cityName) {
        String url = GO_EURO_API_URL + cityName;
        System.out.printf(LOCATION_INFO_LOADING_MSG, cityName, url);
        Object result = HttpHelper.doGet(url);
        LocationInfoList locationInfoList = null;
        try {
            if (result instanceof Throwable) {
                throw (Throwable) result;
            } else {
                locationInfoList = JsonHelper.decode((String) result, LocationInfoList.class);
            }
        } catch (Throwable t) {
            System.out.println(DATA_FAILURE_MSG);
        }
        if (locationInfoList == null || locationInfoList.isEmpty()) {
            System.out.println(EMPTY_RESPONSE_MSG);
        } else {
            System.out.println(GENERATING_CSV_MSG);
            String fileName = CSVHelper.exportData(locationInfoList, cityName);
            System.out.printf(FILE_SUCCESSFUL_SAVE_MSG, fileName);
        }
    }
}
