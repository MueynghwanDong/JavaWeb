package com.ssafy.day11.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ResultSaxParseTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		CheckHandler ch = new CheckHandler();
		parser.parse(ResultSaxParseTest.class.getResourceAsStream("../../../../share/data/result.xml"), ch);
		System.out.println(ch.getList());
	}
}
