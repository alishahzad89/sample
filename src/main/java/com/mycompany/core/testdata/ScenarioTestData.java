package com.mycompany.core.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.jetty.html.List;

import cucumber.api.DataTable;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams.LocalizedXStream;

public class ScenarioTestData{
	
	public void addDataToTable() {
//		ArrayList<String> list=new ArrayList<String>();
//		list.add("Rajiv");
//		list.add("Sharma");
		
		java.util.List<java.util.List<String>> raw = Arrays.asList( Arrays.asList("h1", "h2"), Arrays.asList("v1", "v2") ); 
		DataTable dataTable = DataTable.create(raw, Locale.getDefault(), "h1", "h2");
	
		
//		
//		List<List<String>> infoInTheRaw = Arrays.asList( Arrays.asList("h1", "h2"),
//			    Arrays.asList("v1", "v2") ); 
//			DataTable dataTable = DataTable.create(infoInTheRaw);
			
	}
	public static Map<String,String> getMap(){
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("Balance", "500");
		map.put("Account", "Saving");
		return map;
		
	}
	
	public static void main(String[] args) {
		getDataFromExcel();
	}
	
	public static void getDataFromExcel() {
		  try {

	            FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\rajiv.sharma\\Documents\\TestData.xls"));
	            Workbook workbook = new HSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    
	                    switch (currentCell.getCellType()) {
	                    case Cell.CELL_TYPE_NUMERIC:
	                        System.out.print(currentCell.getNumericCellValue() + "\t");
	                        break;
	                    case Cell.CELL_TYPE_STRING:
	                        System.out.print(currentCell.getStringCellValue() + "\t");
	                        break;
	                    }
	                    

	                }
	                System.out.println();

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
