package com.learn.io.stream;

import java.io.IOException;

public class IOUtil02 {

	public static void main(String[] args) {
		try {
			String fileName = "file.txt";
			IOUtil.printHexByByteArray(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
