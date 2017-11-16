package com.accesshq.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	FileInputStream inputStream;
	Workbook workbook;

	private void getWorkbook(String excelFilePath) throws IOException 
	{
		inputStream = new FileInputStream(new File(excelFilePath));

		if (excelFilePath.endsWith("xlsx")) 
		{
			workbook = new XSSFWorkbook(inputStream);

		} else if (excelFilePath.endsWith("xls")) 
		{
			workbook = new HSSFWorkbook(inputStream);
		} else 
		{
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
	}

	private void closeWorkbook() throws IOException
	{
		workbook.close();
		inputStream.close();
	}

	private Map<Object, Object> readSheet(String sheetName, int rowNum)
	{
		Map<Object, Object> sheetMap = new HashMap<>();

		Sheet sheet = workbook.getSheet(sheetName);

		Row headerRow = sheet.getRow(0);
		int noOfColumns = headerRow.getPhysicalNumberOfCells();

		Row row = sheet.getRow(rowNum);

		for(int c = 0; c < noOfColumns; c++)
		{
			Cell headerCell = headerRow.getCell(c);
			Cell cell = row.getCell(c);

			Object columnName = getCellValue(headerCell);
			Object value = getCellValue(cell);

			sheetMap.put(columnName, value);
		}

		return sheetMap;

	}

	private Object getCellValue(Cell cell) 
	{
		switch (cell.getCellTypeEnum()) 
		{
		case STRING:
			return cell.getStringCellValue();

		case BOOLEAN:
			return cell.getBooleanCellValue();

		case NUMERIC:
			return cell.getNumericCellValue();
		case BLANK:
			return "";
		case _NONE:
			return "";
		default:
			break;
		}

		return null;
	}

	public static Map<Object, Object> readData(String excelPath, String sheetName, int rowNum)
	{
		Map<Object, Object> sheetMap = new HashMap<>();
		
		try
		{
			ExcelReader excelReader = new ExcelReader();
			excelReader.getWorkbook(excelPath);
			sheetMap = excelReader.readSheet(sheetName, rowNum);
			excelReader.closeWorkbook();
		
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return sheetMap;
	}

	public static void main(String[] args) 
	{
		ExcelReader excelReader = new ExcelReader();
		try
		{
			excelReader.getWorkbook("./data.xlsx");
			Map<Object, Object> sheetMap = excelReader.readSheet("login", 1);
			System.out.println(sheetMap);
			excelReader.closeWorkbook();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}