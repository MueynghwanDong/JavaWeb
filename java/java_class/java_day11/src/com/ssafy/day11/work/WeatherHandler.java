package com.ssafy.day11.work;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherHandler extends DefaultHandler {
	List<Weather> list;
	Weather weather = null;
	String text = null;

	public List<Weather> getList() {
		return list;
	}

	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Weather>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("data")) {
			weather = new Weather();
			list.add(weather);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("hour")) {
			weather.setHour(Integer.parseInt(text));
		} else if (qName.equals("temp")) {
			weather.setTemp(Double.parseDouble(text));
		} else if (qName.equals("wfKor")) {
			weather.setWfKor(text);
		} else if (qName.equals("reh")) {
			weather.setReh(Integer.parseInt(text));
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text = String.valueOf(ch, start, length);
	}

}
