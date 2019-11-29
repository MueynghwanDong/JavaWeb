package com.ssafy.day11.work;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class WeatherDAO2 {
	private List<Weather> list = new ArrayList<>();
	private static WeatherDAO2 dao = new WeatherDAO2();
	
	private WeatherDAO2() {};
	
	public static WeatherDAO2 getDao() {
		return dao;
	}
	
	public List<Weather> getWeatherList() throws ParserConfigurationException, SAXException, IOException {
		dao.connectXML();
		
		return list;
	}
	
	public void connectXML() throws ParserConfigurationException, SAXException, IOException {
		String strUrl = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2824573000";
		URL url = new URL(strUrl);
		InputStream input = url.openStream();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		WeatherHandler wh = new WeatherHandler();
		parser.parse(input, wh);
		
		list = wh.getList();
	}
}
