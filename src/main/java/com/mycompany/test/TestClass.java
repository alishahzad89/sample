package com.mycompany.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		String[] strArray= {"\"--plugin\", \"pretty\",\"--plugin\", \"html:target/cucumber-reports\", \"--plugin\", \"json:target/cukjson/cucumber2.json\",\"--glue, com.mycompany.feature.imp\", \"--glue\", \"MyStepdef\", \"--snippets\", \"UNDERSCORE\""};

		List<String> list = new ArrayList(Arrays.asList(strArray));

		list.add("src//test/resources//features//Feature1\\.feature");
		System.out.println("feature file added");
		


	}

}
