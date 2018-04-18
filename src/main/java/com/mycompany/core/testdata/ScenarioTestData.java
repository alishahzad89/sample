package com.mycompany.core.testdata;

import java.util.Map;

public class ScenarioTestData {

	public static Map<String, String> headerList;
	
	public static void main(String[] args) {
		ExcelTestDataUtility ScenarioTestData = new ExcelTestDataUtility("C:\\Users\\rajiv.sharma\\Documents\\TestData.xls","124");
		ScenarioTestData.getDataFromExcel();
		ScenarioTestData.fillTestDataToMap();
		
		System.out.println("getting all values "+headerList);
		System.out.println("getting valie "+headerList.get("balance"));
		
		System.out.println(ScenarioTestData.getTestDataList());
		
	}
	
}
