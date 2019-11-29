package com.ssafy.day11.sax;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	List<Info> infos;
	Info info = null;
	String data = null;
	
	public List<Info> getInfos() {
		return infos;
	}
	
	@Override
	public void startDocument() throws SAXException {
		infos = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		System.out.println("요소 시작 "  + qName);
		if(qName.equals("정보")) {
			info = new Info();
			infos.add(info);
			
			for(int i=0; i<attributes.getLength(); i++) {
				String name = attributes.getQName(i);
				String value = attributes.getValue(i);
				
				if(name.equals("주민번호")) {
					info.setSsn(value);
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
//		System.out.println("요소 종료 : " + qName);
		if(qName.equals("이름")) {
			info.setName(data);
		} else if (qName.equals("email")) {
			info.setEmail(data);
		} else if (qName.equals("휴대전화") ) {
			info.setPhone(data);
		} else if (qName.equals("주소")){
			info.setAddr(data);
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
//		System.out.println("내용" + String.valueOf(ch, start, length));
		this.data = String.valueOf(ch, start, length);
	}
	
	
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("문서 종료");
	}
}
