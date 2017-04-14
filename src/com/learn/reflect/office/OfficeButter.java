
public class OfficeButter {

	public static void main(String[] args) {
		try {
			//动态加载类，在运行时刻加载
			Class class1 = Class.forName(args[0]);			
			//通过类类型，创建该类对象
			//Word work =(Word) class1.newInstance();
			//work.start();
			
			//??这里要可以同时加载Excel或者Word类该怎么办呢？
			//可以使用动态为完成
			OfficeInterface office =(OfficeInterface) class1.newInstance();
			office.start();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
