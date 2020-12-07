package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.text.RegularExpressions;

class RegularExpressionsTest {

	@Test
	void testRegex() {
//		assertTrue("a1".matches(RegularExpressions.getTestRegex()));
//		assertTrue("asdfghj3567".matches(RegularExpressions.getTestRegex()));
//		assertTrue("c1".matches(RegularExpressions.getTestRegex()));
//		assertFalse("b".matches(RegularExpressions.getTestRegex()));
//		assertFalse("c12".matches(RegularExpressions.getTestRegex()));
		
		assertTrue("1-23657".matches(RegularExpressions.getTestRegex()));
		assertTrue("123657".matches(RegularExpressions.getTestRegex()));
		assertFalse("-1-23657".matches(RegularExpressions.getTestRegex()));
	}
	
	@Test
	void javaVariable() {
		assertTrue("$".matches(RegularExpressions.javaVariable()));
		assertTrue("__".matches(RegularExpressions.javaVariable()));
		assertTrue("a".matches(RegularExpressions.javaVariable()));
		assertFalse("1".matches(RegularExpressions.javaVariable()));
		assertFalse("1a".matches(RegularExpressions.javaVariable()));
		assertFalse("_".matches(RegularExpressions.javaVariable()));
		assertFalse("$ 12".matches(RegularExpressions.javaVariable()));
	}
	
	@Test
	void testLess256() {
		
		assertTrue("0".matches(RegularExpressions.less256()));
		assertTrue("012".matches(RegularExpressions.less256()));
		assertTrue("1".matches(RegularExpressions.less256()));
		assertTrue("25".matches(RegularExpressions.less256()));
		assertTrue("199".matches(RegularExpressions.less256()));
		assertTrue("255".matches(RegularExpressions.less256()));
		assertTrue("0255".matches(RegularExpressions.less256()));
		
		assertFalse("256".matches(RegularExpressions.less256()));
		assertFalse("-1".matches(RegularExpressions.less256()));
		assertFalse("260".matches(RegularExpressions.less256()));
		assertFalse("2 0".matches(RegularExpressions.less256()));
	}
	
	@Test
	void testIsraelMobilePhone() {
		assertTrue("+972-50-1-22-33-44".matches(RegularExpressions.israelMobilePhone()));
		assertTrue("+972541223344".matches(RegularExpressions.israelMobilePhone()));
		assertTrue("057-1223344".matches(RegularExpressions.israelMobilePhone()));
		assertTrue("058-122-33-44".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("057+1223344".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("050-1-22-33-445".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("50-1-22-33-44".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("972-50-1-22-33-445".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("+972-050-1-22-33-44".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("050-1-22-33-4t5".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("057-122—3344".matches(RegularExpressions.israelMobilePhone()));
		assertFalse("051-122-33-44".matches(RegularExpressions.israelMobilePhone()));
	}
	
	@Test
	void testEmailAddress() {
		assertTrue("yuragranovsky@gmail.com".matches(RegularExpressions.emailAddress()));
		assertTrue("tt%2@mail.ru".matches(RegularExpressions.emailAddress()));
		assertTrue("tt_67@co.il.d-d.a-a".matches(RegularExpressions.emailAddress()));
		assertTrue("t5&4_s@ff.gt".matches(RegularExpressions.emailAddress()));
		
		assertFalse("yu ra@gmail.com".matches(RegularExpressions.emailAddress()));
		assertFalse("yu,ra@gmail.com".matches(RegularExpressions.emailAddress()));
		assertFalse("tt%2@ma_il.ru".matches(RegularExpressions.emailAddress()));
		assertFalse("tt_67@co.il.dd.aa.bb".matches(RegularExpressions.emailAddress()));
		assertFalse("t5&4_s@ffgt".matches(RegularExpressions.emailAddress()));
		assertFalse("tt_67@co.-il.dd.aa".matches(RegularExpressions.emailAddress()));
		}
	
	@Test
	void testIPv4() {
		
		// <less256>.<less256>.<less256>.<less256> - format IPv4
		String ipV4Regex = RegularExpressions.ipV4();
		assertTrue("0.0.0.0".matches(ipV4Regex));
		assertTrue("127.200.80.01".matches(ipV4Regex));
		assertTrue("255.255.255.255".matches(ipV4Regex));
		
		assertFalse("-1.0.0.0".matches(ipV4Regex));
		assertFalse("10.0.0.0.1".matches(ipV4Regex));
		assertFalse("10.0.0".matches(ipV4Regex));
		assertFalse("10.0.0&0".matches(ipV4Regex));
		assertFalse("10.0.0.0.".matches(ipV4Regex));
		}

}
