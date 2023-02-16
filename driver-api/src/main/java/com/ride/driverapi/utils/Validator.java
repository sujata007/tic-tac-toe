package com.ride.driverapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";
	public static String phoneRegex = "(0/91)?[7-9][0-9]{9}";

	public static boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidMobileNo(String str) {
		Pattern ptrn = Pattern.compile(phoneRegex);
		Matcher match = ptrn.matcher(str);
		return (match.find() && match.group().equals(str));
	}
}
