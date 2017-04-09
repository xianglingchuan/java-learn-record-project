package com.learn.basicSyntax.jdbc.view;

import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.learn.basicSyntax.jdbc.action.GoddessAction;
import com.learn.basicSyntax.jdbc.model.Goddess;

public class View {

	private static final String CONTEXT = "欢迎来到女神禁区：\n" + "下面是女神禁区的功能列表：\n" + "[MAIN/M]:主菜单\n" + "[QUERY/Q]:查看全部女神的信息\n"
			+ "[GET/G]:查看某位女神的详细信息\n" + "[ADD/A]:添加女神信息\n" + "[UPDATE/U]:更新女神信息\n" + "[DELETE/D]:删除女神信息\n"
			+ "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n" + "[EXIT/E]:退出女神禁区\n" + "[BREAK/B]:退出当前功能，返回主菜单";

	private static final String OPERATION_MAIN = "MAIN";
	private static final String OPERATION_QUERY = "QUERY";
	private static final String OPERATION_GET = "GET";
	private static final String OPERATION_ADD = "ADD";
	private static final String OPERATION_UPDATE = "UPDATE";
	private static final String OPERATION_DELETE = "DELETE";
	private static final String OPERATION_SEARCH = "SEARCH";
	private static final String OPERATION_EXIT = "EXIT";
	private static final String OPERATION_BREAK = "BREAK";

	public static void main(String[] args) {

		// 怎么保持程序一直运行
		Scanner scanner = new Scanner(System.in);
		System.out.println(CONTEXT);
		String remember = null; // 用于记忆上一步操作
		int setp = 1; // 用于记录在某一个子功能中是第几步操作
		Goddess goddess = new Goddess();
		GoddessAction goddessAction = new GoddessAction();
		while (scanner.hasNext()) {
			String iString = scanner.next();
			// 退出操作
			if (OPERATION_EXIT.equals(iString.toUpperCase())
					|| OPERATION_EXIT.substring(0, 1).equals(iString.toUpperCase())) {
				System.out.println("你已成功退出女神禁区！");
				break;

				// 返回主菜单
			} else if (OPERATION_MAIN.equals(iString.toUpperCase())
					|| OPERATION_MAIN.substring(0, 1).equals(iString.toUpperCase())) {
				System.out.println(CONTEXT);
				setp = 1;
				remember = "";
				//查看全部女神
			}else if(OPERATION_QUERY.equals(iString.toUpperCase())
					|| OPERATION_QUERY.substring(0, 1).equals(iString.toUpperCase())){	
				try {
					List<Goddess> list = goddessAction.query();
					for (Goddess goddess2 : list) {
						System.out.println("女神ID: "+goddess2.getId()+" 姓名:"+goddess2.getUserName());
					}
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("查看全部女神失败");
				}
			   
			//删除女神信息	
			}else if(OPERATION_DELETE.equals(iString.toUpperCase())
					|| OPERATION_DELETE.substring(0, 1).equals(iString.toUpperCase()) || OPERATION_DELETE.equals(remember)){	
				remember = OPERATION_DELETE;
				if(setp==1){
					try {
						List<Goddess> list = goddessAction.query();
						for (Goddess goddess2 : list) {
							System.out.println("女神ID: "+goddess2.getId()+" 姓名:"+goddess2.getUserName());
						}
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("查看全部女神失败");
					}					
					System.out.println("请输入要踢出的女神ID号:");
				}else if(setp==2){
					int goddessId = Integer.valueOf(iString);
					try {
						goddessAction.delGoddess(goddessId);
						System.out.println("踢出女神成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("踢出女神失败");
					}
					setp = 0;
				}else{
					System.out.println("你输入踢出女神的参数是"+iString);
					setp = 0;					
				}
				if (OPERATION_DELETE.equals(remember)) {
					setp++;
				}
				//查看单个女神信息
			}else if(OPERATION_GET.equals(iString.toUpperCase())
					|| OPERATION_GET.substring(0, 1).equals(iString.toUpperCase()) || OPERATION_GET.equals(remember)){
				remember = OPERATION_GET;
				if(setp==1){
					try {
						List<Goddess> list = goddessAction.query();
						for (Goddess goddess2 : list) {
							System.out.println("女神ID: "+goddess2.getId()+" 姓名:"+goddess2.getUserName());
						}
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("查看全部女神失败");
					}					
					System.out.println("请输入女神的ID号:");
				}else if(setp==2){
					int goddessId = Integer.valueOf(iString);
					try {
						goddess = goddessAction.get(goddessId);
						if(goddess!=null){
							System.out.println("ID:"+goddess.getId());
							System.out.println("年龄:"+goddess.getAge());
							System.out.println("性别:"+goddess.getSex());
							System.out.println("手机号:"+goddess.getMobile());
							System.out.println("邮箱:"+goddess.getEmail());
							System.out.println("生日:"+goddess.getBirthday());
						}else{
							System.out.println("女神信息不存在.");
						}						
					} catch (SQLException e) {
						System.out.println("女神信息不存在.");
						e.printStackTrace();
					}
					setp = 1;
					continue;
				}else{
					System.out.println("你输入的参数是"+iString);
					setp = 0;
				}
				if (OPERATION_GET.equals(remember)) {
					setp++;
				}
				// 添加女神
			} else if (OPERATION_ADD.equals(iString.toUpperCase())
					|| OPERATION_ADD.substring(0, 1).equals(iString.toUpperCase()) || OPERATION_ADD.equals(remember)) {
				remember = OPERATION_ADD;
				if (setp == 1) {
					System.out.println("请输入女神姓名：");
				} else if (setp == 2) {
					goddess.setUserName(iString);
					System.out.println("请输入女神年龄：");
				} else if (setp == 3) {
					goddess.setAge(Integer.valueOf(iString));
					System.out.println("请输入女神生日 格式如：yyyy-MM-dd");
				} else if (setp == 4) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date birthday = null;
					try {
						birthday = simpleDateFormat.parse(iString);
						goddess.setBirthday(new Date(birthday.getTime()));
						System.out.println("请输入女神Email");
					} catch (ParseException e) {
						System.out.println("你输入的格式错误，请重新输入");
						e.printStackTrace();
						setp = 3;
					}
				} else if (setp == 5) {
					goddess.setEmail(iString);
					System.out.println("请输入女神手机号");
				} else if (setp == 6) {
					goddess.setMobile(iString);
					goddess.setSex(1);
					goddess.setIsdel(0);
					try {
						goddessAction.createGoddess(goddess);
						System.out.println("女神添加成功");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("女神添加失败");
					}
					setp = 1;
					remember = "";
					continue;
				}
				if (OPERATION_ADD.equals(remember)) {
					setp++;
				}

			} else {
				System.out.println("你输入的值为:" + iString);
			}
		}

	}

}
