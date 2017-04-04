package com.learn.basicSyntax.collectionMap.bean;

/*
 * 课程类
 * 
 * */
public class Course {
	
	private int id;  //课程ID
	 
	private String name; //课程名称

	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Course(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	/*
	 * 重写equals方法
	 * */
//	public boolean equals(Object object){
//		System.out.println("equals..");
//		if(this == object){
//			return true;
//		}
//		if(object==null){
//			return false;
//		}
//		if(!(object instanceof Course)){
//			return false;
//		}
//		Course course = (Course)object;
//		if(this.name==null && course.getName()==null){
//			if(this.id==course.getId()){
//				return true;
//			}else{
//				return false;
//			}
//		}else{
//			if(this.name.equals(course.getName())){
//				if(this.id==course.getId()){
//					return true;
//				}else{
//					return false;
//				}
//			}
//		}
//		return false;
//	}
	
}
