package com.ssafy.day11.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.day11.sax.Info;

public class SimpleDom {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		Document doc = builder.parse(new File("./bin/share/data/addr.xml"));
		
		Element root = doc.getDocumentElement();
		System.out.println(root);
//		getNode(root);
//		getNode2(root);
		
		
		// xml에 등록된 모든 정보의 이름을 출력하시오.
		System.out.println(getAllUserNames(root));
	}
	
	public static List<String> getAllUserNames(Element root) {
		List<String> names = new ArrayList<>();
		NodeList nodes = root.getElementsByTagName("이름");
		
		for(int i=0; i<nodes.getLength(); i++) {
			names.add(nodes.item(i).getTextContent());
		}
		
		return names;
	}
	
	public static void getNode(Node parent) {
		for(Node ch = parent.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
			if(ch.getNodeType() == Element.ELEMENT_NODE) {
				System.out.println(ch.getNodeName() + " : " + ch.getTextContent());
				getNode(ch);
			}
		}
	}
	
	public static void getNode2(Node root) {
		NodeList nodes = root.getChildNodes();
		
		for(int i=0; i < nodes.getLength(); i++) {
			Node child = nodes.item(i);
			
			if(child.getNodeType() == Element.ELEMENT_NODE) {
				System.out.println(child.getNodeName() + " : " + child.getNodeValue());
			}
		}
	}
}
