package com.ssafy.day11.work;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class WeatherMain {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		showList();
	}
	
	public static void addEvent() {
		
	}
	
	public static void showList() throws IOException, ParserConfigurationException, SAXException {
		WeatherDAO dao = WeatherDAO.getDao();
		WeatherDAO2 dao2 = WeatherDAO2.getDao();
		
		List<Weather> list = dao2.getWeatherList();
		
		for(Weather w : list) {
			System.out.println(w);
		}
				
	}
}
