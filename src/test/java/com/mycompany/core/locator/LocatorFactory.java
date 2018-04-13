package com.mycompany.core.locator;

public class LocatorFactory{



	public static <T> T getInstance(Class<T> theClass) {

		    try {
				return theClass.newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

}
