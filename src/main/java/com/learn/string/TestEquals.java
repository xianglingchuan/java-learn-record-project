package com.learn.string;

/**
 *
 *  测试字符串"=="与"equals"对比
 * 
 */
public class TestEquals {

	public static void main(String[] args) {
		
		String aString = "java";
		String bString = "java";
		String cString = new String("java");
		String dString = new String("java");
		String eString = aString;
		String fString = new String(aString);
		String gString = aString + "";
		
		if(aString ==bString){
			System.out.println("aString==bString is true");
		}else{
			System.out.println("aString==bString is false");
		}
		
		if(aString ==cString){
			System.out.println("aString==cString is true");
		}else{
			System.out.println("aString==cString is false");
		}
		
		if(cString==dString){
			System.out.println("cString==dString is true");
		}else{
			System.out.println("cString==dString is false");
		}		
		
		if(aString==eString){
			System.out.println("aString==eString is true");
		}else{
			System.out.println("aString==eString is false");
		}
		
		if(aString==fString){
			System.out.println("aString==fString is true");
		}else{
			System.out.println("aString==fString is false");
		}
		
		if(aString==gString){
			System.out.println("aString==gString is true");
		}else{
			System.out.println("aString==gString is false");
		}
		
		if(aString.equals(bString) && bString.equals(cString) && cString.equals(dString) && dString.equals(fString) && fString.equals(gString)){
			System.out.println("all value equals true");
		}else{
			System.out.println("all value equals false");
		}
		
		StringBuffer stringBuffera = new StringBuffer("spring");
		StringBuffer stringBufferb = new StringBuffer(stringBuffera+"");
		if(stringBuffera == stringBufferb){
			System.out.println("stringBuffera==stringBufferb is true");
		}else{
			System.out.println("stringBuffera==stringBufferb is true");
		}
		Object object = new Object();
		
		
		String s1 = "foo";  
		String s2 = "bar";  
		String s3 = s1 + s2;
		System.out.println("s3==="+s3);
		
		
	}
	
}
