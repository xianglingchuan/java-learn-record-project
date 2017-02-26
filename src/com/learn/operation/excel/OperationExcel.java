package com.learn.operation.excel;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.WritableByteChannel;


import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Boolean;
import jxl.write.DateFormat;
import jxl.write.Number;
import jxl.write.DateTime;

public class OperationExcel {

	public static void main(String[] args) {

		OperationExcel operationExcel = new OperationExcel();
		
		//operationExcel.readExcelFile("E:/file.xls");
		
		File newFile = new File("E://javaWork2/resource/file2.xls");
		operationExcel.createExcelFile(newFile);
		
		
	}

	/**
	 * 只能通过API提供的 工厂方法来创建Workbook，而不能使用WritableWorkbook的构造函数，
	 * 因为类WritableWorkbook的构造函数为 protected类型： 方法一：直接从目标文件中读取 WritableWorkbook
	 * wwb = Workbook.createWorkbook(new File(targetfile)); 方法 二：如下实例所示
	 * 将WritableWorkbook直接写入到输出流
	 * 
	 */
	public void createExcelFile(File file) {
		
		try {
			WritableWorkbook wwWorkbook = Workbook.createWorkbook(file);
			//创建Excel工作表，指定名称和位置
			WritableSheet ws = wwWorkbook.createSheet("Test Sheet 1", 0);
			//往工作表中添加数据
			//1、添加Lable对象
			Label label = new Label(0,0, "测试");
			ws.addCell(label);
			//添加带有字型Formatting对象
			WritableFont wfFont = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true);
			WritableCellFormat wcf = new WritableCellFormat(wfFont);
			Label labelcf = new Label(1,0,"this is a label test",wcf);
			ws.addCell(labelcf);
			
			//添加带有字体颜色的Formatting对象
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.DARK_YELLOW);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			Label labelCF = new Label(1,0,"Ok",wcfFC);
			ws.addCell(labelCF);
			
			//2 添加Number对象
			Number labelN = new Number(0,1,3.1415926);
			ws.addCell(labelN);
			
			//3 添加Boolean对象
			Boolean labelB = new jxl.write.Boolean(0,2,true);
			ws.addCell(labelB);
			Boolean labelB1 = new jxl.write.Boolean(1,2,false);
			ws.addCell(labelB1);
			
			//4添加DataTime对象
			DateTime lableDT = new DateTime(0,3,new java.util.Date());
			ws.addCell(lableDT);
			
			//添加带有formatting的DateFormat对象
			DateFormat df = new DateFormat("dd MM yyyy hh:mm:ss");
			WritableCellFormat wCellFormat = new WritableCellFormat(df);
			DateTime labelDTF = new DateTime(1,3,new java.util.Date(),wCellFormat);
			ws.addCell(labelDTF);
			
			//添加图片对象，jxl只支持png格式图片
			File image = new File("E://javaWork2/resource/1.png");
			WritableImage wrImage = new WritableImage(0, 4, 6, 17, image);
			ws.addImage(wrImage);
			
			wwWorkbook.write();
			wwWorkbook.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcelFile(String fileName) {
		jxl.Workbook readwb = null;
		// 构建Workbook对象，只读Workbook对象
		// 直接从本地文件创建Workbook
		try {
			InputStream inStream = new FileInputStream(fileName);
			readwb = Workbook.getWorkbook(inStream);

			// Sheet的下标是从0开始
			// 获取第一张Sheet表
			Sheet readSheet = readwb.getSheet(0);
			int sheetCount = readwb.getNumberOfSheets();
			System.out.println("sheetCount:" + sheetCount);
			// 获取Sheet表中包含的总列表
			int rsColumns = readSheet.getColumns();
			System.out.println("rsColumns:" + rsColumns);
			// 获取Sheet表包含的总行数
			int rsRows = readSheet.getRows();
			// 获取指定单元格的对象引用
			for (int i = 0; i < rsRows; i++) {
				for (int j = 0; j < rsColumns; j++) {
					Cell cell = readSheet.getCell(j, i);
					System.out.print(cell.getContents() + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (readwb != null) {
				readwb.close();
			}
		}
	}

}
