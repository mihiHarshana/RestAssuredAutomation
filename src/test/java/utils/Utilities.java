package utils;

import org.json.JSONObject;

public class Utilities {
	
	public JSONObject createJsonObject() {
		
		JSONObject joData = new JSONObject();
		joData.put("year", 2023);
		joData.put("price", 1555);
		joData.put("CPU model", "core i5");
		joData.put("Hard disk", "512 SSD");
		
		JSONObject joMain = new JSONObject();
		joMain.put("name", "MyTestObject");
		joMain.put("data", joData);
		
		return joMain;
		
	}

}
