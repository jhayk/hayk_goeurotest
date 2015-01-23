package com.goeuro.helpers;

import com.goeuro.items.GeoPosition;
import com.goeuro.items.LocationInfo;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;

import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by hayk on 1/23/15.
 */
public class CSVHelper {

	public static String exportData(List<LocationInfo> locationInfoList, String cityName) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet worksheet = wb.createSheet(cityName);
		HSSFRow row = null;
		HSSFCellStyle headerStyle = wb.createCellStyle();
		headerStyle.setWrapText(true);
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		addHeaderRow(worksheet, headerStyle);
		if (locationInfoList != null) {
			for (LocationInfo locationInfo : locationInfoList) {
				row = worksheet.createRow(worksheet.getLastRowNum() + 1);
				row.createCell(0).setCellValue(locationInfo.getId());
				row.createCell(1).setCellValue(locationInfo.getName());
				row.createCell(2).setCellValue(locationInfo.getType());
				GeoPosition geoPosition = locationInfo.getGeoPosition();
				if (geoPosition != null) {
					row.createCell(3).setCellValue(geoPosition.getLatitude());
					row.createCell(4).setCellValue(geoPosition.getLongitude());
				}
			}
			for (short i = 0; i <= row.getLastCellNum(); i++) {
				worksheet.autoSizeColumn(i);
			}
		}
		String fileName = String.format("%s_location_info_%d.csv", cityName, System.currentTimeMillis());
		try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
			wb.write(fileOut);
			fileOut.flush();
		} catch (Exception e) {
			fileName = null;
			e.printStackTrace();
		}
		return fileName;
	}

	private static void addHeaderRow(HSSFSheet sheet, HSSFCellStyle style) {
		String[] headers = {
			"Id", "Name", "Type", "Longitude", "Latitude"};
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;
		for (int i = 0; i < headers.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(style);
		}
	}
}