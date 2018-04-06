package com.mycompany.test;

import org.testng.IInvokedMethod;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.internal.platform.grid.SeleniumGridListener;

public class CukSeleniumGridLisstener extends SeleniumGridListener {

	public boolean isSeLionAnnotatedTestClass(IInvokedMethod method) {
		Class<?> cls = method.getTestMethod().getInstance().getClass();
		final boolean isWebTestClass = cls.getAnnotation(WebTest.class) != null;
		final boolean isMobileTestClass = cls.getAnnotation(MobileTest.class) != null;
		return isMobileTestClass || isWebTestClass;
	}
	
	

}
