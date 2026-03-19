package demo_DDT_prac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingDataFromDataProvider {
	
	@DataProvider(name = "KeyValueData")
	public Object[][] getData(){
		
		return new Object[][] {
			{"key", "value"},
			{"username", "Admin"},
			{"password", "admin123"},
		};
	}
	
	@Test(dataProvider = "KeyValueData")
	public void test(String key, String value) {
		System.out.println(key + " : " + value);
	}
//	
//	@DataProvider(name = "KeyValueTypesData")
//	public Object[][] getDataVariousTypes(){
//		
//		return new Object[][] {
//			{"key", 1},
//			{"username", 2},
//			{"password", 3},
//		};
//	}
//	
//	@Test(dataProvider = "KeyValueTypesData")
//	public void testtypes(String key, int value) {
//		System.out.println(key + " : " + value);
//	}

	
	
//	@DataProvider(name = "KeyValueDataTriple")
//	public Object[][] getDataTriple(){
//		
//		return new Object[][] {
//			{"key", "value", "keyvalue"},
//			{"username", "Admin", "username-admin"},
//			{"password", "admin123", "loginData"},
//		};
//	}
	
//	@Test(dataProvider = "KeyValueDataTriple")
//	public void test2(String key, String value, String extra) {
//		System.out.println(key + " : " + value + " " + extra);
//	}
	
	

	@DataProvider(name = "KeyValueMixData")
	public Object[][] getDataMixVariousTypes(){
		
		return new Object[][] {
			{"key", 1},
			{"username", "String"},
			{"password", new int[] {}},
		};
	}
	
	@Test(dataProvider = "KeyValueMixData")
	public void testtypes(Object key, Object value) {
		System.out.println(key + " : " + value);
	}
	
	

}
