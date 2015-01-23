package com.goeuro;

/**
 * Created by hayk on 1/23/15.
 */
public class Constants {
	public static final String GO_EURO_API_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	public static final String EXIT = "e";
	public static final String READ_CITY_NAME_NOTIFICATION = "Please type city name or type '" + EXIT + "' to exit the program\n";
	public static final String CMD_READ_FAILURE_MSG = "Exception thrown when reading from command line  >>>>> %s";
	public static final String LOCATION_INFO_LOADING_MSG = "Getting information about %s through this url: %s\n";
	public static final String DATA_FAILURE_MSG = "Failed to load data...";
	public static final String EMPTY_RESPONSE_MSG = "No data to generate csv file.";
	public static final String GENERATING_CSV_MSG = "Generating csv file, please wait..............";
	public static final String FILE_SUCCESSFUL_SAVE_MSG = "Files saved successfully! \nName of the file: %s\n";
	public static final String WELCOME_MSG = "************** Welcome ************";
}
