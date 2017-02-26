package com.learn.operation.excel.bean;

public class DayVisit {

	
	private String timeLength;
	private int userCount;
	private float ratio;
	
	public DayVisit(){
		
	}
	
	public DayVisit(String timeLength, int userCount, float ratio) {
		super();
		this.timeLength = timeLength;
		this.userCount = userCount;
		this.ratio = ratio;
	}



	public String getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "DayVisit [timeLength=" + timeLength + ", userCount=" + userCount + ", ratio=" + ratio + "]";
	}

	
	
	
	
}
