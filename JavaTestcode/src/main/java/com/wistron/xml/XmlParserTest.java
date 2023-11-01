package com.wistron.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class XmlParserTest {
    @Test
    public void testDomParser() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("for_xml_parser.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        Document document = db.parse(file);
        NodeList nodeList = document.getElementsByTagName("Value");
        for (int i=0;i<nodeList.getLength();i++){
            System.out.println(document.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
            System.out.println(document.getElementsByTagName("Address").item(i).getFirstChild().getNodeValue());
        }
    }

    @Test
    public void testSAXParser(){

    }
}

class MySaxParserHandler extends DefaultHandler{

}
