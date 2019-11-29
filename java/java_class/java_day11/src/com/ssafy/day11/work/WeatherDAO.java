package com.ssafy.day11.work;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

public class WeatherDAO {
	private List<Weather> list = new ArrayList<>();
	private static WeatherDAO dao = new WeatherDAO();

	private WeatherDAO() {}
	
	public List<Weather> getWeatherList() throws IOException, ParserConfigurationException, SAXException {
		dao.connectXML();
		return list;
	}
	
	public static WeatherDAO getDao() {
		return dao;
	}

	public void connectXML() throws IOException, ParserConfigurationException, SAXException {
		String strUrl = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2824573000";
		URL url = new URL(strUrl);
		InputStream input = url.openStream(); 

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		Document doc = builder.parse(input);
		Element root = doc.getDocumentElement();
		
		NodeList nodes = root.getElementsByTagName("data");
		
		for(int i=0; i<nodes.getLength(); i++) {
			Node node = nodes.item(i);
			Weather weather = new Weather();
			list.add(weather);
			
			NodeList childs = node.getChildNodes();
			
			for(int j=0; j<childs.getLength(); j++) {
				Node child = childs.item(j);
				
				if(child.getNodeName().equals("hour")) {
					weather.setHour(Integer.parseInt(child.getTextContent()));
				}else if (child.getNodeName().equals("temp")) {
					weather.setTemp(Double.parseDouble(child.getTextContent()));
				}else if (child.getNodeName().equals("wfKor")) {
					weather.setWfKor(child.getTextContent());
				}else if (child.getNodeName().equals("reh")) {
					weather.setReh(Integer.parseInt(child.getTextContent()));
				}
			}
		}
	}
}














