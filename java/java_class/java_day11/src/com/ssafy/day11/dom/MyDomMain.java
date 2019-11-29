package com.ssafy.day11.dom;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.ssafy.day11.sax.Check;
import com.ssafy.day11.sax.Info;

public class MyDomMain {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, DOMException, ParseException {
		MyDomParser mdp = new MyDomParser();
		List<Check> list = mdp.getContent("./bin/share/data/result.xml");
		System.out.println(list);
		
	}
}
