package util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParseService extends DefaultHandler {
    private String preTag = null;// 作用是记录解析时的上一个节点名称
    private static String originXml;
    StringBuffer sb = new StringBuffer();

    public SaxParseService() {
    }

    @SuppressWarnings("static-access")
    public SaxParseService(String originXml) {
        this.originXml = originXml;
    }

    public String getParseXml(InputStream xmlStream) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParseService handler = new SaxParseService();
        parser.parse(xmlStream, handler);
        return handler.getParseXml();
    }

    public String getParseXml() {
        return sb.toString();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument!");
        super.startDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("startElement:" + qName);
        if (!originXml.toString().contains("</" + qName + ">")) {
            return;
        }
        sb.delete(0, sb.length()); // 清除字符内容
        preTag = qName;// 将正在解析的节点名称赋给preTag
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("endElement:" + qName);
        preTag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(ch);
        if (preTag != null) {
            sb.append(ch, start, length);// 字符相加
        }
    }

    public static void main(String[] args) throws Exception {
        String requestXml = "<book><name>thinking> in java </name><price>20.2</price></book>";
        SaxParseService sax = new SaxParseService(requestXml);
        InputStream xmlStream = new ByteArrayInputStream(requestXml.getBytes());
        String parseXml = sax.getParseXml(xmlStream);
        System.out.println(parseXml);
    }

    public String getOriginXml() {
        return originXml;
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println("startPrefixMapping:" + prefix);
        super.startPrefixMapping(prefix, uri);
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        System.out.println("processingInstruction:" + target + "," + data);
        super.processingInstruction(target, data);
    }
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
        System.out.println("resolveEntity:" + publicId + "," + systemId);
        return super.resolveEntity(publicId, systemId);
    }
}
