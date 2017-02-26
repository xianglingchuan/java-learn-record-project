package com.learn.basicSyntax.bean;

public class TelPhone {

	

	private float size;
	private float cup;
	private int memory;
	
	
	
	public float getSize() {
		return size;
	}


	public void setSize(float size) {
		this.size = size;
	}


	public float getCup() {
		return cup;
	}


	public void setCup(float cup) {
		this.cup = cup;
	}


	public int getMemory() {
		return memory;
	}


	public void setMemory(int memory) {
		this.memory = memory;
	}


	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelPhone other = (TelPhone) obj;
		if (Float.floatToIntBits(cup) != Float.floatToIntBits(other.cup))
			return false;
		if (memory != other.memory)
			return false;
		if (Float.floatToIntBits(size) != Float.floatToIntBits(other.size))
			return false;
		return true;
	}

	
	
	
}
