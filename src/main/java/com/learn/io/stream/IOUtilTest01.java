package com.learn.io.stream;

import java.io.IOException;

public class IOUtilTest01 {

	public static void main(String[] args) {
		
		try {
			String fileName = "file.txt";
			IOUtil.printHex(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
