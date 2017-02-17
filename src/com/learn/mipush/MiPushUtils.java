package com.learn.mipush;

import com.xiaomi.xmpush.server.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.learn.mipush.bean.PushBean;


public class MiPushUtils {

	private final static int PASS_THROUGH_MESSAGE = 0;// 1表示透传消息
	private final static int NOTIFICATION_MESSAGE = 0;// 0表示通知栏消息
	private final static int PASS_THROUGH = NOTIFICATION_MESSAGE;// 1表示透传消息，0表示通知栏消息

	private final static int DEFAULT_ALL = -1;
	private final static int DEFAULT_SOUND = 1; // 使用默认提示音提
	private final static int DEFAULT_VIBRATE = 2; // 使用默认震动提示
	private final static int DEFAULT_LIGHTS = 4; // 使用默认led灯光提示
	private final static int NOTIFY_TYPE = DEFAULT_ALL;

	private String ANDROID_APP_SECRET = "";
	private String IOS_APP_SECRET = "";
	private String ANDROID_PACKAGE_NAME = "";
	private static int  DEVELOPMENT_MODE = 1;   //1=正式环境/0=测试
	
	
	public final static int TYPE_ANDROID = 0;
	public final static int TYPE_IOS = 1;

   
	/**
	 * 构造函数
	 */
    public MiPushUtils(String androidAppSecret, String androidPackageName, String iosAppSecret, int developmentMode){
    	this.ANDROID_APP_SECRET = androidAppSecret;
    	this.ANDROID_PACKAGE_NAME = androidPackageName;
    	this.IOS_APP_SECRET = iosAppSecret;
    	MiPushUtils.DEVELOPMENT_MODE = developmentMode;
    }
    

    /**
	 * 调用小米推送
	 */
	public static void reStartPush(int deviceType) {
        //如果为测试环境		
 		if (DEVELOPMENT_MODE == 0) {
			// 测试环境只提供对IOS支持，不支持Android
			Constants.useSandbox();
			if (deviceType == TYPE_ANDROID) {
				Constants.useOfficial();
			}
		} else {
			// 正式环境 
			Constants.useOfficial();
		}
	}

	/**
	 * 根据regid发送一条短信
	 *
	 * @param title
	 * @param content
	 * @param regId
	 * @param deviceType
	 * @throws Exception
	 */
	private Result sendMessage(String title, String content, String regId, int deviceType, long timeToSend) throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); // 需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); // 需要根据appSecert来发送
		}
		Message message = buildMessage(title, content, deviceType, timeToSend);
		Result result = sender.send(message, regId, (int) timeToSend); // 根据regID，发送消息到指定设备上，不重试。
		return result;
	}

	/**
	 * 根据alias发送一条短信
	 *
	 * @param title
	 * @param content
	 * @param userMobile
	 * @param deviceType
	 * @throws Exception
	 */
	private Result sendMessageToAlias(String title, String content, String userMobile, int deviceType)
			throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); // 需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); // 需要根据appSecert来发送
		}
		Result result = sender.sendToAlias(buildMessage(title, content, deviceType, 0), userMobile, 0); // 根据alias，发送消息到指定设备上，不重试。
		return result;
	}
	
	
	
	/**
	 * 向所有设备发送推送信息
	 *
	 * @param title
	 * @param content
	 * @param deviceType
	 * @param timeToSend
	 * @throws Exception
	 */
	public Result sendBroadcastAll(String title, String content, int deviceType,  int timeToSend) throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); //需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); //需要根据appSecert来发送
		}		
		Result result = sender.broadcastAll(buildMessage(title, content, deviceType, timeToSend), 0); 
		return result;
	}
	

	/**
	 * 给一个用户发送一群短信
	 *
	 * @param pushBeans
	 * @param userMobile
	 * @param deviceType
	 * @throws Exception
	 */
	private Result sendMessages(List pushBeans, String userMobile, int deviceType) throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); // 需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); // 需要根据appSecert来发送
		}
		Result result = sender.send(buildMessages(pushBeans, userMobile, deviceType), 0); // 根据alias，发送消息到指定设备上，不重试。
		return result;
	}

	/**
	 * 给一群用户发送一条短信
	 *
	 * @param title
	 * @param content
	 * @param userMobiles
	 * @param deviceType
	 * @throws Exception
	 */
	private Result sendMessageToAliases(String title, String content, List userMobiles, int deviceType)
			throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); // 需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); // 需要根据appSecert来发送
		}
		Result result = sender.sendToAlias(buildMessage(title, content, deviceType, 0), userMobiles, 0);// 根据aliasList，发送消息到指定设备上，不重试。
		return result;
	}

	/**
	 * 发送广播 根据topic，发送消息到指定一组设备上
	 *
	 * @param title
	 * @param content
	 * @param topic
	 * @param deviceType
	 * @throws Exception
	 */
	private Result sendBroadcast(String title, String content, String topic, int deviceType) throws Exception {
		reStartPush(deviceType);
		Sender sender = null;
		if (deviceType == TYPE_ANDROID) {
			sender = new Sender(ANDROID_APP_SECRET); // 需要根据appSecert来发送
		} else if (deviceType == TYPE_IOS) {
			sender = new Sender(IOS_APP_SECRET); // 需要根据appSecert来发送
		}
		Result broadcast = sender.broadcast(buildMessage(title, content, deviceType, 0), topic, 0);// 根据topic，发送消息到指定一组设备上，不重试。
		return broadcast;
	}

	/**
	 * TargetedMessage封装了MiPush推送服务系统中的消息Message对象，和该Message对象所要发送到的目标
	 *
	 * @param pushBeans
	 * @param userMobile
	 * @param deviceType
	 * @return messages
	 * @throws ChaEChaException
	 */
	private List buildMessages(List<PushBean> pushBeans, String userMobile, int deviceType) throws Exception {
		List messages = new ArrayList();
		for (PushBean pushBean : pushBeans) {
			TargetedMessage message1 = new TargetedMessage();
			message1.setTarget(TargetedMessage.TARGET_TYPE_ALIAS, userMobile);
			message1.setMessage(buildMessage(pushBean.getTitle(), pushBean.getContent(), deviceType, 0));
			messages.add(message1);
		}
		return messages;
	}

	/**
	 * 构建发送信息
	 *
	 * @param title
	 * @param content
	 * @param deviceType
	 * @param timeToSend
	 * @return Message
	 */
	private Message buildMessage(String title, String content, int deviceType, long timeToSend) throws Exception {
		Message message = null;
		if (deviceType == TYPE_ANDROID) {
			message = buildMessage2Android(title, content, timeToSend);
		} else if (deviceType == TYPE_IOS) {
			message = buildMessage2IOS(content, timeToSend);
		}
		return message;
	}

	/**
	 * 构建android推送信息
	 *
	 * @param title
	 * @param content
	 * @param timeToSend
	 * @return
	 */
	private Message buildMessage2Android(String title, String content, long timeToSend) throws Exception {
		Message message = new Message.Builder().title(title).description(content).payload(content)
				.restrictedPackageName(ANDROID_PACKAGE_NAME)// 设置包名
				.passThrough(PASS_THROUGH) // 消息使用透传方式
				.notifyType(NOTIFY_TYPE) // 使用默认提示音提示
				.enableFlowControl(true) // 控制消息是否需要进行平缓发送
				.timeToSend(timeToSend)  //定时推送时间
				.build();
        return message;
	}
	

	/**
	 * 构建ios推送信息
	 *
	 * @param content
	 * @param timeToSend
	 * @return
	 */
	private Message buildMessage2IOS(String content,long timeToSend) throws Exception {
		Message message = new Message.IOSBuilder().description(content).badge(1) // 数字角标
				.timeToSend(timeToSend)
				.build();
		return message;
	}
	
	
	
	public static void main(String agrs[]) {
		MiPushUtils miPushUtils = new MiPushUtils("3fSLWUZLVvfg6UOKNCnHyw==","com.snaillove.test","",1);
		try {
			
			//向所有android用户发送推送消息
			Result result2 = miPushUtils.sendBroadcastAll("java push test", "java push content", TYPE_ANDROID, 0);
			System.out.println("push Android result2 is " + result2.toString());
			
			
			//向单个Android用户发送推送消息
			String regId = "00Z+fht3K9/hO+/chMpoOlwb+BuHTWyVF0Qk0/zKt/4=";
			Result result = miPushUtils.sendMessage("java push test(regId:"+regId+")", "java push content(regId:"+regId+")", regId, TYPE_ANDROID, 0);
			System.out.println("push Android result is " + result.toString());

			
		    long currentTime = System.currentTimeMillis() + 60 * 2 * 1000;
		    System.out.println("currentTime:"+currentTime);		    
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		    Date date = new Date(currentTime);
		    String datetime = simpleDateFormat.format(date);
		    System.out.println(datetime);
			//发送订时推送消息
			Result result3 = miPushUtils.sendMessage("java push test(regId:"+regId+", datetime:"+datetime+")", "java push content(regId:"+regId+")", regId, TYPE_ANDROID, currentTime);
			System.out.println("push Android result3 is " + result3.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
