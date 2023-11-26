package com.wistron.xml;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.jdom2.*;

public class XmlParserTest {
    @Test
    public void testDomParser() throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
        File file = new File("for_xml_parser.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        //需要配合DTD使用
//        documentBuilderFactory.setValidating(true);
//        documentBuilderFactory.setIgnoringElementContentWhitespace(false);

        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = db.parse(file);


        org.w3c.dom.Element documentElement = document.getDocumentElement();

        //修改对应元素的属性值
//        NodeList persons = documentElement.getElementsByTagName("Person");
//        for(int i=0;i<persons.getLength();i++){
//            org.w3c.dom.Element personElement = (org.w3c.dom.Element) persons.item(i);
//            String id = personElement.getAttribute("id");
//            if(id.equals("2")){
//                personElement.setAttribute("id", "100");
//            }
//        }

        //获取根元素, 然后获取根元素的子nodes
//        Element documentElement = document.getDocumentElement();
//        NodeList childNodes = documentElement.getChildNodes();
//        for(int i=0;i<childNodes.getLength();i++){
//            System.out.println(childNodes.item(i).getNodeName());
//        }
//        System.out.println(documentElement.getNodeName());

//        NodeList nodeList = document.getElementsByTagName("Person");
//        for (int i=0;i<nodeList.getLength();i++){
//            System.out.println(document.getElementsByTagName("Name").item(i).getTextContent());
//        }

//        //往XML文件当中增加一个元素
//        org.w3c.dom.Element personElement = document.createElement("Person");
////        Attr personAttrId = document.createAttribute("id");
//        personElement.setAttribute("id", "3");
//        org.w3c.dom.Element nameElement = document.createElement("Name");
//        nameElement.setTextContent("chaochao");
//        personElement.appendChild(nameElement);
//        documentElement.appendChild(personElement);

        //通过XPath去删除一个node
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        org.w3c.dom.Element personElement = (org.w3c.dom.Element) xPath.evaluate("/People/Person[@id='1']", document, XPathConstants.NODE);
        documentElement.removeChild(personElement);
        //保存修改后的数据
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult( new File("test.xml")));
    }

    @Test
    public void testSAXParser() throws ParserConfigurationException, SAXException, IOException {
//        SAXParserFactory spf = SAXParserFactory.newInstance();
//        SAXParser saxParser = spf.newSAXParser();
//        File file = new File("for_xml_parser.xml");
//        saxParser.parse(file, new MySaxParserHandler());

        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(new MySaxParserHandler());
        xmlReader.parse(new InputSource("for_xml_parser.xml"));
    }

    @Test
    public void testJDom() throws IOException, JDOMException {
        SAXBuilder sb = new SAXBuilder();
        org.jdom2.Document d = sb.build(new File("for_xml_parser.xml"));
        org.jdom2.Element element = d.getRootElement();
        List<org.jdom2.Element> children = element.getChildren();
        for(org.jdom2.Element e : children){
            System.out.println(e.getAttribute("id").getValue());
        }
    }

    @Test
    public void testDom4j() throws DocumentException {
        File file = new File("for_xml_parser.xml");
        SAXReader sr = new SAXReader();
        org.dom4j.Document document = sr.read(file);
        org.dom4j.Element rootElement = document.getRootElement();
        Iterator<org.dom4j.Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()){
            org.dom4j.Element element = elementIterator.next();
            System.out.println(element.attribute("t").getValue());
        }
    }

    //Test Java XPath API
    @Test
    public void testXPath() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        File file = new File("for_xml_parser.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = db.parse(file);
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();


        //根据表达式, 获取单个Node
//        Node o1 = (Node)xPath.evaluate("//Name", document, XPathConstants.NODE);
//        System.out.println(o1.getNodeType());
//        Element element = (Element) xPath.evaluate("//Name", document, XPathConstants.NODE);
//        System.out.println(element.getTextContent());

        //根据表达式, 获取Node集合
//        NodeList nodeList = (NodeList) xPath.evaluate("/People/Person/*", document, XPathConstants.NODESET);
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.println("========"+nodeList.item(i).getNodeName() + " ");
//        }

        //根据表达式, 筛选出element
//        Element element = (Element) xPath.evaluate("/People/*[name()='Person2']", document, XPathConstants.NODE);
//        System.out.println(element.getAttribute("id"));

        //获取包含子节点的元素
//        NodeList nodeList = (NodeList) xPath.evaluate("/People/*[*]", document, XPathConstants.NODESET);
//        for(int i=0;i<nodeList.getLength();i++){
//            String nodeName = nodeList.item(i).getNodeName();
//            System.out.println(nodeName);
//        }

        //获取指定层级元素
//        NodeList nodeList = (NodeList) xPath.evaluate("/*/*/*", document, XPathConstants.NODESET);
//        for(int i=0;i<nodeList.getLength();i++){
//            String nodeName = nodeList.item(i).getNodeName();
//            System.out.println(nodeName);
//        }

        //根据属性值获取对应的Element
//        Element element = (Element) xPath.evaluate("/People/Person[Address[@nation='China']]/Address", document, XPathConstants.NODE);
//        System.out.println(element.getTextContent());

        org.w3c.dom.Element element = (org.w3c.dom.Element) xPath.evaluate("/People/Person/..", document, XPathConstants.NODE);
        System.out.println(element.getTextContent().length());
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
