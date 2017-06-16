//package com.learn.operation.excel;
//
//import java.awt.List;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//
//import jxl.Cell;
//import jxl.CellType;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.write.Label;
//
//import com.learn.operation.excel.bean.DayVisit;
//
//public class DayVisitOperation {
//
//	public static void main(String[] args) {
//		DayVisitOperation dayVisitOperation = new DayVisitOperation();
//		
//		ArrayList<ArrayList<DayVisit>> sheetList = new ArrayList<ArrayList<DayVisit>>();
//		ArrayList<ArrayList<DayVisit>> carSheetList = new ArrayList<ArrayList<DayVisit>>();
//		for(int i=1; i<=12; i++){
//			//炫灯的内容读取
////			ArrayList<DayVisit> list = dayVisitOperation.readExcelFile("E:/javaWork2/resource/炫灯/"+i+".xls");
////		    for (DayVisit dayVisit : list) {
////		    	System.out.println(dayVisit.toString());
////		    }		
////		    sheetList.add(list);
//		    
//		    
//		    //车载数据读取
//			ArrayList<DayVisit> carList = dayVisitOperation.readExcelFile("E:/javaWork2/resource/车载/"+i+".xls");
//		    for (DayVisit dayVisit : carList) {
//		    	System.out.println(dayVisit.toString());
//		    }		
//		    carSheetList.add(carList);
//		}
//		//dayVisitOperation.creaExcelFile("E:/javaWork2/resource/user.xls", sheetList, 1);
//		dayVisitOperation.creaExcelFile("E:/javaWork2/resource/友盟用户分析统计.xls", carSheetList, 2);
//	}
//	
//	
//	
//	
//	public void creaExcelFile(String fileName, ArrayList<ArrayList<DayVisit>> sheetList, int sheetIndex){
//		
//		jxl.Workbook readwb = null;
//		// 构建Workbook对象，只读Workbook对象
//		// 直接从本地文件创建Workbook
//		try {
//			InputStream inStream = new FileInputStream(fileName);
//			readwb = Workbook.getWorkbook(inStream);
//
//			// Sheet的下标是从0开始
//			// 获取第一张Sheet表
//			Sheet readSheet = readwb.getSheet(sheetIndex);
//			int sheetCount = readwb.getNumberOfSheets();
//			System.out.println("sheetCount:" + sheetCount);
//			// 获取Sheet表中包含的总列表
//			int rsColumns = readSheet.getColumns();
//			System.out.println("rsColumns:" + rsColumns);
//			// 获取Sheet表包含的总行数
//			int rsRows = readSheet.getRows();
//			// 获取指定单元格的对象引用
//			for (int i = 0; i < rsRows; i++) {
//				for (int j = 0; j < rsColumns; j++) {
//					Cell cell = readSheet.getCell(j, i);
//					System.out.print(cell.getContents() + " ");
//				}
//				System.out.println();
//			}
//			
//			
//			//利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄   
//			jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File("E:/javaWork2/resource/user01.xls"), readwb);   
//            //读取第一张工作表   
//            jxl.write.WritableSheet ws = wwb.getSheet(sheetIndex);  
//            //插入标题
//            String[] title = {"1-3秒(用户)",  "1-3秒(占比)", 
//            		          "4-10秒(用户)", "4-10秒(占比)", 
//            		          "11-30秒(用户)", "11-30秒(占比)",             		          
//            		          "31-60秒(用户)", "31-60秒(占比)", 
//            		          "1-3分(用户)", "1-3分(占比)", 
//            		          "3-10分(用户)", "3-10分(占比)",
//            		          "10-30分(用户)", "10-30分(占比)",
//            		          "30分~(用户)", "30分~(占比)"};        
//            for(int i=0; i<title.length; i++){
//    			Label label = new Label((i+2),0, title[i]);
//    			ws.addCell(label);
//            }
//            
//            //开始循环
//            if(sheetList.size()>=1){
//            	int rowIndex = 1;
//            	for (ArrayList<DayVisit> dayVisitList : sheetList) {
//            		if(dayVisitList.size()>=1){
//            			int lineIndex = 2;
//            			for (DayVisit dayVisit : dayVisitList) {
//							System.out.println(dayVisit.toString());
//							
//							Label label = new Label(lineIndex,rowIndex, dayVisit.getUserCount()+"");
//							ws.addCell(label);
//							
//							Label label2 = new Label(lineIndex+1,rowIndex, dayVisit.getRatio()+"");
//							ws.addCell(label2);
//							
//							lineIndex +=2;
//						}
//            		}
//            		rowIndex++;
//            		
//				}
//            }
//            //写入Excel对象   
//            wwb.write();   
//            wwb.close();   
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (readwb != null) {
//				readwb.close();
//			}																																																																													
//		}
//	}
//	
//
//	
//	
//	
//	public ArrayList<DayVisit> readExcelFile(String fileName) {
//		jxl.Workbook readwb = null;
//		// 构建Workbook对象，只读Workbook对象
//		// 直接从本地文件创建Workbook
//		ArrayList<DayVisit> list = new ArrayList<DayVisit>();
//		try {
//			InputStream inStream = new FileInputStream(fileName);
//			readwb = Workbook.getWorkbook(inStream);
//			// Sheet的下标是从0开始
//			// 获取第一张Sheet表
//			Sheet readSheet = readwb.getSheet(0);
//			int sheetCount = readwb.getNumberOfSheets();
//			System.out.println("sheetCount:" + sheetCount);
//			// 获取Sheet表中包含的总列表
//			int rsColumns = readSheet.getColumns();
//			System.out.println("rsColumns:" + rsColumns);
//			// 获取Sheet表包含的总行数
//			int rsRows = readSheet.getRows();
//			// 获取指定单元格的对象引用
//			for (int i = 0; i < rsRows; i++) {
//				if(i!=0){
//					DayVisit dayVisit = new DayVisit();
//					for (int j = 0; j < rsColumns; j++) {
//						Cell cell = readSheet.getCell(j, i);
//						System.out.print(cell.getContents() + " ");
//						if(j==0){
//							dayVisit.setTimeLength(cell.getContents());
//						}else if(j==1){
//							dayVisit.setUserCount(new Integer(cell.getContents()));
//						}else if(j==2){
//							dayVisit.setRatio(new Float(cell.getContents()));
//						}											
//					}
//					list.add(dayVisit);				
//					System.out.println();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (readwb != null) {
//				readwb.close();
//			}
//		}
//		return list;
//	}
//	
//	
//	
//}
