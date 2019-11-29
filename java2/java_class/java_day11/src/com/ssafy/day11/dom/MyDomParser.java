package com.ssafy.day11.dom;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.day11.sax.Check;


public class MyDomParser {
	public List<Check> getContent(String url) throws ParserConfigurationException, SAXException, IOException, DOMException, ParseException {
		List<Check> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		Document doc =  builder.parse(new File(url));
		Element root = doc.getDocumentElement();
		
		NodeList nodes = root.getElementsByTagName("check");
		
		for(int i=0; i < nodes.getLength(); i++) {
			Node checkNode = nodes.item(i);
			Check check = new Check();
			list.add(check);
			// 속성 가져오기
			NamedNodeMap nmap = checkNode.getAttributes();
			check.setCode(Integer.valueOf(nmap.getNamedItem("code").getNodeValue()));
			check.setDate( sdf.parse(nmap.getNamedItem("date").getNodeValue()) );
			
			NodeList childs = checkNode.getChildNodes();
			for(int j=0; j < childs.getLength(); j++) {
				Node child = childs.item(j);
				
				if(child.getNodeName().equals("clean")) {
					check.setClean(child.getTextContent());
				}else if (child.getNodeName().equals("ready")) {
					check.setReady(child.getTextContent());
				}else if (child.getNodeName().equals("response")) {
					check.setResponse(child.getTextContent());
				}else if (child.getNodeName().equals("request")) {
					check.setRequest(child.getTextContent());
				}
			}
		}
		
		return list;
	}
}



















