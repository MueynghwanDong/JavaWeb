package com.ssafy.day11.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ssafy.day11.sax.Check;

public class JsonResultTest {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("./bin/share/data/result.json");
/*		Gson gson = new Gson();
		Map<String, Object> map = gson.fromJson(reader, Map.class);
		System.out.println(map);
		
		Map<String, Object> checkList = (Map) map.get("checkList");
		System.out.println(checkList);
		
		List<Map<String, Object>> list = (List) checkList.get("check");
		for(Map<String, Object> check : list) {
			System.out.println(check);
			
		}
*/
		
		GsonBuilder gb = new GsonBuilder().setDateFormat("yyyy.MM.dd");
		Gson gson = gb.create();
		Type type = new TypeToken<Map<String, Map<String, List<Check>>>>(){}.getType();
		Map<String, Map<String, List<Check>>> map = gson.fromJson(reader, type);
		System.out.println(map);
		
		System.out.println(map.get("checkList").get("check").get(0));
	}
}
