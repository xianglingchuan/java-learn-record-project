package com.springmvc.common.util;

/**
 * 提供读取配置文件参数的类
 * 
 * @author Administrator
 *
 */
public class Common {
	private static PropertiesLoader loader = new PropertiesLoader("common.properties");
	// 不同环境的配置文件
	private static PropertiesLoader loaderEnvironmentCommon;
	
	private static String developmentEnvironment;

	static {
		developmentEnvironment = loader.getProperty("development_environment");
		developmentEnvironment = developmentEnvironment.equals("") ? "dev" : developmentEnvironment;
		loaderEnvironmentCommon = new PropertiesLoader("common/common_" + developmentEnvironment + ".properties");
	}
	
	
	public static String getDevelopmentEnvironment(){
		return developmentEnvironment;
	}

	public static String getPictureURLPath() {
		return loaderEnvironmentCommon.getProperty("resource.domain")
				+ loaderEnvironmentCommon.getProperty("upload.picture");
	}

	public static String getPictureDiskPath() {
		return loaderEnvironmentCommon.getProperty("upload.path")
				+ loaderEnvironmentCommon.getProperty("upload.picture");
	}

	public static String getVoiceURLPath() {
		return loaderEnvironmentCommon.getProperty("resource.domain")
				+ loaderEnvironmentCommon.getProperty("upload.voice");
	}

	public static String getVoiceDiskPath() {
		return loaderEnvironmentCommon.getProperty("upload.path") + loaderEnvironmentCommon.getProperty("upload.voice");
	}

	public static String getFileURLPath() {
		return loaderEnvironmentCommon.getProperty("resource.domain")
				+ loaderEnvironmentCommon.getProperty("upload.file");
	}

	public static String getFileDiskPath() {
		return loaderEnvironmentCommon.getProperty("upload.path") + loaderEnvironmentCommon.getProperty("upload.file");
	}
	
	/*
	 * 获取项目资源访问域名地址
	 * 
	 */
	public static String getResourceDomain() {
		return loaderEnvironmentCommon.getProperty("resource.domain");
	}

	/*
	 * 获取项目主域名地址
	 * 
	 */
	public static String getWebDomain() {
		return loaderEnvironmentCommon.getProperty("web.domain");
	}
}