package com.learn.basicSyntax.radix;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Convert {

	
	/**
	 * 将int型转换成字节数组
	 */
	public static byte[] int2Bytes(int id){
		byte[] arr = new byte[4];
//        arr[0] = (byte)((int)(id>>0*8) & 0xff);
//        arr[1] = (byte)((int)(id>>1*8) & 0xff);
//        arr[2] = (byte)((int)(id>>2*8) & 0xff);
//        arr[3] = (byte)((int)(id>>3*8) & 0xff);
		for(int i=0; i<arr.length; i++){
			arr[i] = (byte)((int)(id>>i*8) & 0xff);
		}
		return arr;
	}
	
	/**
	 * 将byte[]数组转换成int类型
	 */	
    public static int bytes2Int(byte[] arr){
//    	int rs0 = (int)((arr[0] & 0xff) << 0*8);
//    	int rs1 = (int)((arr[1] & 0xff) << 1*8);
//    	int rs2 = (int)((arr[2] & 0xff) << 2*8);
//    	int rs3 = (int)((arr[3] & 0xff) << 3*8);
//    	return rs0+rs1+rs2+rs3;
    	int result =0;
    	for(int i=0; i<arr.length; i++){
    		result += (int)((arr[i] & 0xff) << i*8);
    	}
    	return result;
    }
	
    
	/**
	 * 将long型转换成字节数组
	 */
	public static byte[] long2Bytes(long id){
		byte[] arr = new byte[8];
		for(int i=0; i<arr.length; i++){
			arr[i] = (byte)((int)(id>>i*8) & 0xff);
		}
		return arr;
	}
	
	/**
	 * 将byte[]数组转换成long类型
	 */	
    public static long bytes2Long(byte[] arr){
    	long result =0;
    	for(int i=0; i<arr.length; i++){
    		result += (int)((arr[i] & 0xff) << i*8);
    	}
    	return result;
    }    
	
	
	public static void main(String[] args) {
		byte[] result = Convert.int2Bytes(1986);
		System.out.println(result[0]+","+result[1]+","+result[2]+","+result[3]);
		int i = Convert.bytes2Int(result);
		System.out.println(i);
		
		System.out.println("==================Long类型的转换==================");
		byte[] result2 = Convert.long2Bytes(121234111);
		for(int ii=0; ii<result2.length; ii++){
			System.out.print(result2[ii]+",");
		}
		System.out.println("");
		System.out.println(Convert.bytes2Long(result2));
		
		String string = "我天天练功，天下无双......";
		byte[] strByte = string.getBytes();
		for(int j=0; j<strByte.length; j++){
			System.out.print(strByte[j]+",");
		}
		System.out.println("");
		System.out.println(new String(strByte));
	}
}
