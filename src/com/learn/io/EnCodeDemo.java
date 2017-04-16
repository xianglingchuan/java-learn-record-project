package com.learn.io;

import java.io.UnsupportedEncodingException;

public class EnCodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String string = "慕课abc";
		byte[] bytes1 = string.getBytes();// 转换成字节序列用的是项目默认的编码utf-8
		System.out.println("===============项目默认编码==================");
		for (byte b : bytes1) {
			// 将字节（转换成了int）以16进制的方式显示
			// b & 0xff 去掉前面的6位二进制字了码
			System.out.print(Integer.toHexString(b & 0xff) + " ");
			// e6 85 95 e8 af be 61 62 63
			// 本项目用的是utf-8, 一个中文在utf-8中站用三个字节，一个英文站用一个字节
		}
		System.out.println();
		System.out.println("===============GBK编码==================");
		try {
			byte[] bytes2 = string.getBytes("gbk");
			for (byte b : bytes2) {
				System.out.print(Integer.toHexString(b & 0xff) + " ");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("===============UTF-8编码==================");
		try {
			byte[] bytes3 = string.getBytes("utf-8");
			for (byte b : bytes3) {
				System.out.print(Integer.toHexString(b & 0xff) + " ");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("===============Java的双字节编码UTF-16be==================");
		// java是双字节编码utf-16be编码
		// utf-16be 中文站用两个字节，英文站用两个字节

		byte[] bytes4 = string.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}

		System.out.println();
		// 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出现乱码
		String str2 = new String(bytes4);
		System.out.println(str2);
		str2 = new String(bytes4, "utf-16be");
		System.out.println(str2);

	}

}
