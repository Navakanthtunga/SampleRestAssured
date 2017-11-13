package com.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GenericClass {

	public static void readdataFromXml(String Filepath,HashMap<String, String> attr) throws ParserConfigurationException, SAXException, IOException
	{
		File fXmlFile = new File(Filepath);	
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		ArrayList<String> al = new ArrayList<String>();
		for(Map.Entry m:attr.entrySet()){
			// System.out.println(m.getKey()+" "+m.getValue());  
			al.add(m.getValue().toString()); // all the attributes to list
		}
		//System.out.println(al.toString());
		//System.out.println(al.size());

		for(int i=0;i<al.size();i++)
		{
			//System.out.println(al.get(i).toString());
		}
		String attr1[] = {};
		for(Map.Entry m1:attr.entrySet()){
			//  System.out.println(m.getKey()+" "+m.getValue());  
			// al.add(m.getValue().toString());
			NodeList nList = doc.getElementsByTagName(m1.getKey().toString());
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					for(int j =0 ;j<al.size();j++)
					{
						String s1 = al.get(j);
						String s2[] = {};
						if(s1.contains(","))
						{
							s2=s1.split(",");
							for(int k=0;k<s2.length;k++)
							{
								System.out.println("Found value for "+s2[k]+" - "+eElement.getAttribute(s2[k]));
							}
						}
						else
						{
							System.out.println("Found value for "+s1+" - "+eElement.getAttribute(s1));
						}
						/*System.out.println("City id : " + eElement.getAttribute(attributes.get(j)));
							System.out.println("lon : " + eElement.getAttribute("lon"));
							System.out.println("lat : " + eElement.getAttribute("lat"));*/
						//System.out.println("Nick Name : " + eElement.getElementsByTagName("rise").item(0).getTextContent());
						//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
					}
				}
			}
		}


		/*for(int i =0;i<node.length;i++)
		{
			NodeList nList = doc.getElementsByTagName(nodevalue.get(i));

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						for(int j =0 ;j<atrr.length;j++)
						{
							System.out.println("City id : " + eElement.getAttribute(attributes.get(j)));
							System.out.println("lon : " + eElement.getAttribute("lon"));
							System.out.println("lat : " + eElement.getAttribute("lat"));
						//System.out.println("Nick Name : " + eElement.getElementsByTagName("rise").item(0).getTextContent());
						//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
						}
					}

		}


	}*/

	}
}
