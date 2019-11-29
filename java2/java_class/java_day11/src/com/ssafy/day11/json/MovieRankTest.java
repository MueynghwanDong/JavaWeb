package com.ssafy.day11.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class MovieRankTest {
	public static void main(String[] args) throws IOException {
		String urlStr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20190805";
		URL url = new URL(urlStr);
		InputStream input = url.openStream();
		Gson gson = new Gson();
		
		Map<String, Object> map = gson.fromJson(new BufferedReader(new InputStreamReader(input)), Map.class);
		Map<String, Object> boxOfficeResult = (Map<String, Object>) map.get("boxOfficeResult");
		List<Map<String, String>> dailyBoxOfficeList = (List<Map<String, String>>) boxOfficeResult.get("dailyBoxOfficeList");
		
		System.out.println(dailyBoxOfficeList);
		
		for(Map<String, String> m : dailyBoxOfficeList) {
			System.out.println(m.get("rank") + " : " +  m.get("movieNm"));
			
		}
	}
}
