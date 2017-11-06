package com.mode.analogjdkproxy.proxy;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


public class Proxy {

	
	public static Object newProxyInstance(Class infce) throws Exception{
		
		//定义一个换行符
		String rt = "\r\n";
		String iClassName = infce.getName();
		
		String methodStr = "";
		for (Method method : infce.getMethods()) {
			String methodName = method.getName();
			methodStr =
			"	@Override"+rt+
			"	public void "+methodName+"() {"+rt+
			"		long startTime = System.currentTimeMillis();"+rt+
			"		System.out.println(\"--记录开始时间......\"+startTime);"+rt+
			"		moveable."+methodName+"();"+rt+
			"		long endTime = System.currentTimeMillis();"+rt+
			"		System.out.println(\"--记录结束时间......运行时间为:\"+ (endTime - startTime) + \"毫秒\");"+rt+
			"	}";		
		}	
	
		
		//将时间代理类的代理直接复制进入
		String str =
		"package com.mode.analogjdkproxy.proxy;"+rt+
		"public class $Proxy0 implements "+iClassName+"{"+rt+
		"	private "+iClassName+" moveable;"+rt+
		"	public $Proxy0(DTrainMoveable moveable) {"+rt+
		"		this.moveable = moveable;"+rt+
		"	}"+rt+methodStr+
		"}";
		
		//产生代理类的java文件
		//生成的代理类名称为: com.sun.proxy.$Proxy0
        //String filename = System.getProperty("user.dir")+"/bin/com/mode/analogjdkproxy/proxy/$Proxy0.java";
		String filename = System.getProperty("user.dir") +"/target/classes/com/mode/analogjdkproxy/proxy/$Proxy0.java";
		File file = new File(filename);
		org.apache.commons.io.FileUtils.writeStringToFile(file, str);
		
        //编译
		//拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理者
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//进行编译
		t.call();
		fileMgr.close();
		
		//load到内存
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		Class c =  classLoader.loadClass("com.mode.analogjdkproxy.proxy.$Proxy0");
		
		Constructor constructor = c.getConstructor(infce);
		return constructor.newInstance(new DTrain());
	}
}
