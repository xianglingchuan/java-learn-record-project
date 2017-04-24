package com.learn.io.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("demo/file.txt");
		FileWriter fileWriter = new FileWriter("demo/file_new.txt",true);
		
		char[] chars = new char[1024];
		int ichar;
		while ((ichar=fileReader.read(chars,0,chars.length))!=-1) {
			System.out.print(chars);
			fileWriter.write(chars);
			fileWriter.flush();
		}
		fileWriter.close();
		fileReader.close();

	}

}
