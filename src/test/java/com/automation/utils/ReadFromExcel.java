package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table;

public class ReadFromExcel {
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int lastRow;
	int lastCell;
	Map<String, String> data;
	ReadFromProperties readprop = new ReadFromProperties();
	String filePath = readprop.getTestInputFilePath();
	String[][] table;

	@Test(enabled = false)
	public void readExcelold() {
		try {
			file = new File(filePath);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("");
			lastRow = sheet.getLastRowNum();

			Map<String, String> data = new HashMap<String, String>();
			String[][] table = new String[lastRow][2];
			for (int i = 0; i <= lastRow; i++) {
				row = sheet.getRow(i);
				// System.out.println(row.getCell(0).getStringCellValue().toString());
				// System.out.println(row.getCell(1).getStringCellValue().toString());
				for (int j = 0; j <= row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					table[i][j] = cell.getStringCellValue();

					// data.put(row.getCell(0).getStringCellValue(),
					// row.getCell(1).getStringCellValue());
				}
			}
			// System.out.println(lastCell);
			// System.out.println(cell.getStringCellValue());
			wb.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());

		} finally {

		}
	}

	//@DataProvider(name = "tableData")
	public String[][] readExcel(String sheetName) {
		try {
			file = new File(filePath);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(sheetName);
			lastRow = sheet.getLastRowNum();
			lastCell = sheet.getRow(0).getLastCellNum();
			
			table = new String[lastRow+1][lastCell];
			data = new HashMap<String, String>();
			
			for (int i = 0; i <= lastRow; i++)
			{
				row = sheet.getRow(i);
				//System.out.println(row.getLastCellNum());
				for (int j = 0; j < lastCell; j++) 
				{
					cell = row.getCell(j);
					table[i][j] = cell.getStringCellValue();
				}
				// to put data to Hashmap
				data.put(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue());
			}
			wb.close();
			}
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getClass());
		} 
		finally 
		{
			return table;
		}
	}

}
