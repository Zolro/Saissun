package com.sais.util;

import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.StringReader;  
import java.io.StringWriter;  
  




import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Marshaller;  
import javax.xml.bind.Unmarshaller;  

import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.Attributes;
  
/** 
 * 封装了XML转换成object，object转换成XML的代码 
 *  
 * @author Steven 
 *  
 */  
public class XMLUtil {  
    /** 
     * 将对象直接转换成String类型的 XML输出 
     *  
     * @param obj 
     * @return 
     */  
    public static String convertToXml(Object obj) {  
        // 创建输出流  
        StringWriter sw = new StringWriter();  
        try {  
            // 利用jdk中自带的转换类实现  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
            
            Marshaller marshaller = context.createMarshaller();  
            // 格式化xml输出的格式  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
                    Boolean.TRUE);  
            // 将对象转换成输出流形式的xml  
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
            marshaller.marshal(obj, sw);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return sw.toString();  
    }  
    
    public static String convertToXml(Class fclazz,Class sclazz,Object object) {  
        // 创建输出流  
        StringWriter sw = new StringWriter();  
        try {  
            // 利用jdk中自带的转换类实现  
            JAXBContext context = JAXBContext.newInstance(fclazz.getClass(),sclazz.getClass());  
  
            Marshaller marshaller = context.createMarshaller();  
            // 格式化xml输出的格式  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
                    Boolean.TRUE);  
            // 将对象转换成输出流形式的xml  
            marshaller.marshal(object, sw);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return sw.toString();  
    }  
    /** 
     * 将对象根据路径转换成xml文件 
     *  
     * @param obj 
     * @param path 
     * @return 
     */  
    public static void convertToXml(Object obj, String path) {  
        try {  
            // 利用jdk中自带的转换类实现  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
  
            Marshaller marshaller = context.createMarshaller();  
            // 格式化xml输出的格式  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  
                    Boolean.TRUE);  
            // 将对象转换成输出流形式的xml  
            // 创建输出流  
            FileWriter fw = null;  
            try {  
                fw = new FileWriter(path);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            marshaller.marshal(obj, fw);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
    }  
  
    @SuppressWarnings("unchecked")  
    /** 
     * 将String类型的xml转换成对象 
     */  
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {  
        Object xmlObject = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(clazz);  
            // 进行将Xml转成对象的核心接口  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            StringReader sr = new StringReader(xmlStr);  
            xmlObject = unmarshaller.unmarshal(sr);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return xmlObject;  
    }  
  
    @SuppressWarnings("unchecked")  
    /** 
     * 将file类型的xml转换成对象 
     */  
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {  
        Object xmlObject = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(clazz);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            FileReader fr = null;  
            try {  
                fr = new FileReader(xmlPath);  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
            }  
            xmlObject = unmarshaller.unmarshal(fr);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        }  
        return xmlObject;  
    } 
    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

            StringWriter out = new StringWriter();
            OutputFormat format = new OutputFormat();
            format.setIndent(true);
            format.setNewlines(true);
            format.setNewLineAfterDeclaration(false);
            XMLWriter writer = new XMLWriter(out, format);

            XMLFilterImpl nsfFilter = new XMLFilterImpl() {
                private boolean ignoreNamespace = false;
                private String rootNamespace = null;
                private boolean isRootElement = true;

                @Override
                public void startDocument() throws SAXException {
                    super.startDocument();
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    if (this.isRootElement) this.isRootElement = false;
                    else if (!uri.equals("") && !localName.contains("xmlns")) localName = localName + " xmlns=\"" + uri + "\"";

                    super.startElement(uri, localName, localName, atts);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (this.ignoreNamespace) uri = "";
                    super.endElement(uri, localName, localName);
                }

                @Override
                public void startPrefixMapping(String prefix, String url) throws SAXException {
                    if (this.rootNamespace != null) url = this.rootNamespace;
                    if (!this.ignoreNamespace) super.startPrefixMapping("", url);

                }
            };
            nsfFilter.setContentHandler(writer);
            marshaller.marshal(obj, nsfFilter);
            return out.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}  
