package telran.text;

public class RegularExpressions {
	public static String getTestRegex() {
		// return "a.+|c.?";
		return "(\\d-?\\d){3}";
	}
	
	public static String javaVariable() {
		String regex = "[a-zA-Z$](\\w|_$)*|_(\\\\w|_$)+";
		return regex;
		
	}

	public static String less256() {
		String regex = "0*\\d\\d?|0*1\\d{2}|0*2[0-4]\\d|0*25[0-5]";
		return regex;
	}

	public static String israelMobilePhone() {
		String regex = "(\\+972-?|0)5[02-8](-?\\d){7}";
		return regex;
	}

	public static String emailAddress() {
		
		String firstPart = "[^\\s,]+";
		String domain = "[a-zA-Z0-9]+(-?[a-zA-Z0-9])*";
		String regex = String.format("%1$s@(%2$s\\.){1,3}%2$s", firstPart, domain);
		return regex;
	}
	
	public static String ipAdres() {
		String regex = "0*\\d\\d?|0*1\\d{2}|0*2[0-4]\\d|0*25[0-5]";
		return regex;
	}

	public static String ipV4() {
		String digits = "\\d\\d?|[0-1]\\d\\d|2[0-4]\\d|25[0-5]";
		String regex = String.format("((%1$s)\\.){3}(%1$s)", digits);
		return regex;
	}

}
