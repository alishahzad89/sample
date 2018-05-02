package com.mycompany.core.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelTestDataUtility {

	private LinkedList<String> headerList = new LinkedList<String>();
	private List<HashMap<String, String>> testDataList=new LinkedList<HashMap<String, String>>();
	private Workbook workbook;
	private Sheet datatypeSheet;
	private LinkedList<Row> testDataRow = new LinkedList<Row>();

	final private String excelFilePath;
	final private String testCaseId;

	public ExcelTestDataUtility(String excelFilePath, String testCaseId) {
		this.excelFilePath = excelFilePath;
		this.testCaseId = testCaseId;
	}

	public List<HashMap<String, String>> getTestDataList() {
		return testDataList;
	}

	public List<String> getHeaderList() {
		return headerList;
	}
	

	public void getDataFromExcel() {
		try {
			FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
			workbook = new HSSFWorkbook(excelFile);

			datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iteratorRow = datatypeSheet.iterator();

			boolean testCaseIdFound = false;
			Cell currentCell = null;
			Row currentRow = null;

			while (iteratorRow.hasNext()) {
				currentRow = iteratorRow.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					currentCell = cellIterator.next();
					String currentCellValue = currentCell.toString().replaceAll("\\..*", "");

					if (currentCellValue.toString().equals(testCaseId)) {
						System.out.println("Test Case ID found " + currentCellValue);
						testCaseIdFound = true;
					}

				}

				if (testCaseIdFound && isCurrentTestCaseData(currentRow)) {
					testDataRow.add(currentRow);
				}
			}
			// System.out.println("testDataRow " + testDataRow.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public boolean isCurrentTestCaseData(Row row) {

		try {
			if (row.getCell(0) != null) {
				if (!row.getCell(0).toString().equals(testCaseId)) {

					// System.out.println("first Row in side null "+row.getCell(0));
					return false;

				}
			}
		} catch (Exception e) {
			System.err.println("Exception in finding row data so retrun false");
			return false;
		}
		return true;

	}

	public void fillTestDataToMap() {

		fillRowHeaderList(testDataRow.get(0).iterator());

		for (int i = 1; i < testDataRow.size(); i++) {
			fillTestDataToMap(testDataRow.get(i));
		}
	}

	public void fillTestDataToMap(Row row) {
		int index = 0;
		 HashMap<String, String> mapData = new HashMap<String, String>();
		 
		Iterator<Cell> currentCell = row.cellIterator();
		
		while (currentCell.hasNext()) {
			Cell cell = currentCell.next();
//			 System.out.println("this map " + headerList.get(index) +" "+cell.toString());
			 mapData.put(headerList.get(index), cell.toString());
			
			index++;
		}
		
		testDataList.add(mapData);

	}

	public void fillRowHeaderList(Iterator<Cell> cellIterator) {

		while (cellIterator.hasNext()) {
			Cell currentCell = cellIterator.next();
			if (!currentCell.toString().equals(testCaseId))
				headerList.add(currentCell.toString());
		}
		System.out.println("this is method fillRowHeaderList " + headerList);
	}

}
