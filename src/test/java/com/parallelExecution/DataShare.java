package com.parallelExecution;
/**
 * DataShare class is used to store values (set) from api and pass the values to another api.
 * This will work only when runs both the test from TestNG.xml file.
 * If runs individually, then pass the value to one API will return null and will not work.
 * 
 * 			Or 
 * We can use ITestContext , ISuite which is there in TestNG refer {@link: com.cookiebasedauthentication}
 */
import java.util.LinkedHashMap;

public class DataShare {
	
	private DataShare() {}
	
	private static ThreadLocal<LinkedHashMap<String, Object>> data= 
			ThreadLocal.withInitial(()-> new LinkedHashMap<String,Object>());
	
	public static void setValue(String key, Object value) {
		data.get().put(key, value);
	}
	
	public static Object getValue(String key) {
		return data.get().get(key);
	}
	
	
	
}
