package com.learn.myString;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonGenerationException;

public class JacksonDemo {

	/**
	 * ObjectMapper类是Jackson库的主要类。它提供一些功能将转换成Java对象匹配JSON结构，反之亦然。
	 * 它使用JsonParser和JsonGenerator的实例实现JSON实际的读/写。
	 * 
	 * http://www.yiibai.com/jackson/jackson_data_binding.html
	 * 
	 */

	public static void main(String[] args) {
		// JacksonDemo.JsonFormatStringToStudent();
		// JacksonDemo.serializeJsonFile();
		// JacksonDemo.simpleDataBind();
		// JacksonDemo.bindGenerics();
		// JacksonDemo.foreachTree();
		// JacksonDemo.treeToJson();
		JacksonDemo.treeToJavaBean();

	}

	/**
	 * 将json格式String转换成对象 将对象转换成Json格式
	 */
	public static void JsonFormatStringToStudent() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"isstudent\":true, \"uid\":21, \"uname\":\"Jack\", \"upwd\":\"123456\", \"number\":1001}";
		try {
			Student student = mapper.readValue(jsonString, Student.class);
			System.out.println(student.toString());

			Student student2 = new Student();
			student2.setIsstudent(false);
			student2.setUid(22);
			student2.setUname("mark");
			student2.setUpwd("654321");
			student2.setNumber(12);
			String studentString = mapper.writeValueAsString(student2);
			System.out.println("studentString:" + studentString);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Java对象序列化到一个JSON文件，然后再读取JSON文件获取转换为对象
	 */
	public static void serializeJsonFile() {
		JacksonDemo demo = new JacksonDemo();
		Student student = new Student();
		student.setIsstudent(false);
		student.setUid(22);
		student.setUname("mark");
		student.setUpwd("654321");
		student.setNumber(12);

		try {
			demo.writeJSON(student);
			Student student2 = demo.readJSON();
			System.out.println("student2==>" + student2.toString());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("student.json"), student);
	}

	private Student readJSON() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(new File("student.json"), Student.class);
		return student;
	}

	/**
	 * Jackson数据绑定 简单数据绑定 - 转换JSON，从Java Maps, Lists, Strings, Numbers, Booleans
	 * 和 null 对象。
	 * 
	 */
	public static void simpleDataBind() {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> studentDataMap = new HashMap<String, Object>();

		int[] marks = { 1, 2, 3 };

		Student student = new Student();
		student.setIsstudent(false);
		student.setUid(22);
		student.setUname("mark");
		student.setUpwd("654321");
		student.setNumber(12);

		studentDataMap.put("student", student);
		studentDataMap.put("name", "lili");
		studentDataMap.put("verified", Boolean.FALSE);
		studentDataMap.put("marks", marks);
		try {
			// 写入到json文件中
			mapper.writeValue(new File("text/simpleDataBind.json"), studentDataMap);
			// 读取内容
			studentDataMap = mapper.readValue(new File("text/simpleDataBind.json"), Map.class);
			System.out.println("student:" + studentDataMap.get("student"));
			System.out.println("name:" + studentDataMap.get("name"));
			System.out.println("verified:" + studentDataMap.get("verified"));
			System.out.println("marks:" + studentDataMap.get("marks"));
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Jackson数据绑定泛型
	 * 
	 */
	public static void bindGenerics() {
		ObjectMapper mapper = new ObjectMapper();

		Map userDataMap = new HashMap<>();
		UserData studentData = new UserData();

		int[] marks = { 1, 2, 3 };

		Student student = new Student();
		student.setIsstudent(false);
		student.setUid(22);
		student.setUname("mark");
		student.setUpwd("654321");
		student.setNumber(12);

		studentData.setStudent(student);
		studentData.setMarks(marks);
		studentData.setName("lili");
		studentData.setVerified(Boolean.FALSE);

		userDataMap.put("studentData1", studentData);
		try {
			// 写入文件
			mapper.writeValue(new File("bindGenerics.json"), userDataMap);

			// 读取内容
			TypeReference ref = new TypeReference<Map>() {
			};
			userDataMap = mapper.readValue(new File("bindGenerics.json"), ref);
			Map userMap = (Map) userDataMap.get("studentData1");
			System.out.println("userMap:" + userMap);
			System.out.println(userMap.get("name"));
			System.out.println(userMap.get("marks"));
			System.out.println(userMap.get("verified"));
			System.out.println(userMap.get("student"));

			String str = JSONObject.toJSONString(userMap);
			System.out.println("str:" + str);
			UserData tmpUserData = mapper.readValue(str, UserData.class);
			System.out.println("tmpUserData:" + tmpUserData);
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Jackson树模型
	 * 
	 */
	public static void foreachTree() {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
		try {
			JsonNode rootNode = mapper.readTree(jsonString);

			JsonNode nameNode = rootNode.path("name");
			System.out.println("name:" + nameNode.getTextValue());
			JsonNode ageNode = rootNode.path("age");
			System.out.println("age:" + ageNode.getTextValue());
			JsonNode verifiedNode = rootNode.path("verified");
			System.out.println("verified:" + verifiedNode.getTextValue());

			JsonNode marksNode = rootNode.path("marks");
			Iterator<JsonNode> iterator = marksNode.getElements();
			System.out.println("marks:");
			while (iterator.hasNext()) {
				JsonNode marks = iterator.next();
				System.out.print(marks.getIntValue() + " ");
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Jackson树模型
	 * 
	 */
	public static void treeToJson() {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode rootNode = mapper.createObjectNode();
		JsonNode marksNode = mapper.createArrayNode();
		((ArrayNode) marksNode).add(100);
		((ArrayNode) marksNode).add(90);
		((ArrayNode) marksNode).add(85);
		((ObjectNode) rootNode).put("name", "Mahesh Kumar");
		((ObjectNode) rootNode).put("age", 21);
		((ObjectNode) rootNode).put("verified", false);
		((ObjectNode) rootNode).put("marks", marksNode);

		try {
			mapper.writeValue(new File("text/treeToJson.json"), rootNode);

			rootNode = mapper.readTree(new FileInputStream(new File("text/treeToJson.json")));
			JsonNode nameNode = rootNode.path("name");
			System.out.println("Name: " + nameNode.getTextValue());
			JsonNode ageNode = rootNode.path("age");
			System.out.println("Age: " + ageNode.getIntValue());
			JsonNode verifiedNode = rootNode.path("verified");
			System.out.println("Verified: " + (verifiedNode.getBooleanValue() ? "Yes" : "No"));
			JsonNode marksNode1 = rootNode.path("marks");
			Iterator<JsonNode> iterator = marksNode1.getElements();
			System.out.print("Marks: [ ");
			while (iterator.hasNext()) {
				JsonNode marks = iterator.next();
				System.out.print(marks.getIntValue() + " ");
			}
			System.out.println("]");
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void treeToJavaBean() {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.createObjectNode();
		JsonNode marksNode = mapper.createArrayNode();
		((ArrayNode) marksNode).add(100);
		((ArrayNode) marksNode).add(90);
		((ArrayNode) marksNode).add(85);
		((ObjectNode) rootNode).put("name", "Mahesh Kumar");
		((ObjectNode) rootNode).put("verified", false);
		((ObjectNode) rootNode).put("marks", marksNode);

		try {
			mapper.writeValue(new File("text/treeToJavaBean.json"), rootNode);
			rootNode = mapper.readTree(new FileInputStream(new File("text/treeToJavaBean.json")));
			UserData userData = mapper.treeToValue(rootNode, UserData.class);

			System.out.println("Name: " + userData.getName());
			System.out.println("Verified: " + (userData.getVerified() ? "Yes" : "No"));
			System.out.println("Marks: " + Arrays.toString(userData.getMarks()));
		} catch (org.codehaus.jackson.JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
