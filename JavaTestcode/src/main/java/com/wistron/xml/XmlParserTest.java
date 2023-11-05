package com.wistron.xml;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.*;
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
    public void testSAXParser() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        File file = new File("for_xml_parser.xml");
        saxParser.parse(file, new MySaxParserHandler());

//        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
//        xmlReader.setContentHandler(new MySaxParserHandler());
//        xmlReader.parse(new InputSource("for_xml_parser.xml"));
    }
}

class MySaxParserHandler extends DefaultHandler{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("========================startElement===========================");
        System.out.println("uri="+uri);
        System.out.println("localName="+localName);
        System.out.println("qName="+qName);
        System.out.println("===============================================================");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("========================characters===========================");
        System.out.println("str="+new String(ch, start, length));
        System.out.println("start="+start);
        System.out.println("length="+length);
        System.out.println("===============================================================");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("========================endElement===========================");
        System.out.println("uri="+uri);
        System.out.println("localName="+localName);
        System.out.println("qName="+qName);
        System.out.println("===============================================================");

    }
}
