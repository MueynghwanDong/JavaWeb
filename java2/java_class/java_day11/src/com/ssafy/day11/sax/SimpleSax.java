package com.ssafy.day11.sax;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SimpleSax {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		
		MyHandler mh = new MyHandler();	// 문서 처리의 핵심 ! 핸들러
		CheckHandler ch = new CheckHandler();
		
		// file 기반
/*		System.out.println(new File("./bin/share/data/addr.xml").getCanonicalPath());
		File file = new File("./bin/share/data/addr.xml");
		parser.parse(file, mh);
		*/
		
		// stream 기반
		InputStream is = SimpleSax.class.getResourceAsStream("../../../../share/data/addr.xml");
		parser.parse(is, mh);
		
		System.out.println(mh.getInfos());
	}
}
