package com.mycompany.core.testdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class JsonTestDataUtility {

	private String jsonFilePath = null;
	private String testCaseId = null;
	private List<Map<String,Object>> testDataList=new ArrayList<Map<String,Object>> ();

	public JsonTestDataUtility(String jsonFilePath, String testCaseId) {
		this.jsonFilePath = jsonFilePath;
		this.testCaseId = testCaseId;
	}
	
	public List<Map<String, Object>> getTestDataList() {
		return testDataList;
	}

	public List<String> getHeaderList() {
		return null;
	}

	public void getDataFromJson() throws FileNotFoundException, JSONException {

		Gson gson = new Gson();
		
		
		BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
				
		String json = gson.fromJson(br, JsonElement.class).toString();
		JSONObject obj = new JSONObject(json);

		JSONArray arr = obj.getJSONObject("testcases").getJSONObject(testCaseId).getJSONArray("testdata");
		for(int i=0;i<arr.length();i++) {
		Type countryMapType = new TypeToken<Map<String,Object>>(){}.getType();
		Map<String,Object> countryMap = gson.fromJson(arr.getString(i).toString(), countryMapType);
		testDataList.add(countryMap);
		}
//		System.out.println(testDataList);
		

	}

	public static void main(String[] args) throws FileNotFoundException, JSONException {

		JsonTestDataUtility JsonTestDataUtility = new JsonTestDataUtility(
				"C:\\\\Users\\\\rajiv.sharma\\\\workspace\\\\Sample\\\\src\\\\main\\\\java\\\\com\\\\mycompany\\\\core\\\\testdata\\\\SimpleTestDataJson.json",
				"testcase-124");

		JsonTestDataUtility.getDataFromJson();

	}

	
}
