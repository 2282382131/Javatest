package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValitor {
	
	public static boolean validate(String xsdPath,String xmlPath) {
		boolean flag=false;
		try {
			//����ģʽ���� SchemaFactory
			SchemaFactory sf=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			//ͨ��xsd�ļ�����ģʽSchema
			File f=new File(xsdPath);
			Schema s=sf.newSchema(f);
			//��ģʽ������֤��Validator
			Validator v=s.newValidator();
			//ʹ����֤����֤xml�ļ�
			Source sc=new StreamSource(xmlPath);
			v.validate(sc);
			flag=true;
		} 
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//		String xsdPath="bin//database.conf.xsd";
//		String xmlPath="bin//database.conf.xml";
//		if(XmlValitor.validate(xsdPath, xmlPath))
//			System.out.println("�ɹ�");
//	}

}
