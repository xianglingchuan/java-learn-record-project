package com.mode.factory.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class PropertiesUtil {

	public Map<String, String> getProperties() {

		Properties props = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			Reader reader;
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			//reader = Resources.getResourceAsReader(classloader, "mode/classtype.properties");
			InputStream in =  classloader.getResourceAsStream("mode/classtype.properties");			
			//InputStream in = getClass().getResourceAsStream("type.properties");
			props.load(in);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String property = props.getProperty(key);
				map.put(key, property);
				// System.out.println(key + " " + property);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
