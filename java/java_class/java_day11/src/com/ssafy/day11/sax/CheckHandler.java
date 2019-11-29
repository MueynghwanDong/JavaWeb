package com.ssafy.day11.sax;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CheckHandler extends DefaultHandler {
	List<Check> list;
	Check current = null;
	String text = null;
	
	
	public List<Check> getList() {
		return list;
	}
	
	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<Check>();
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("check")) {
			current = new Check();
			list.add(current);
			
			for(int i=0; i < attributes.getLength(); i++ ) {
				String attrName = attributes.getQName(i);
				String attrValue = attributes.getValue(i);
				
				if(attrName.equals("code")) {
					current.setCode(Integer.parseInt(attrValue));
				} else if (attrName.equals("date")) {
					try {
						current.setDate(sdf.parse(attrValue));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
	}
	
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("clean")) {
			current.setClean(text);
		} else if (qName.equals("ready")) {
			current.setReady(text);
		} else if (qName.equals("response")) {
			current.setResponse(text);
		} else if (qName.equals("request")) {
			current.setRequest(text);
		}
	
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.text = String.valueOf(ch, start, length);
	}
	
}
