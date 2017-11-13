package com.mode.adapter;

public class NoteBook {
	
	private ThreePlugIf plugIf;
	
	
	public NoteBook(ThreePlugIf plugIf){
		this.plugIf = plugIf;
	}
	
	public void charge(){
		this.plugIf.powerWithThree();
	}
	
	public static void main(String[] args) {
		GBTwoPlug twoPlug = new GBTwoPlug();
		TwoPlugAdapter three = new TwoPlugAdapter(twoPlug);
		NoteBook noteBook = new NoteBook(three);
		noteBook.charge();
		
		
		TwoPlugAdapterExtends twoPlugAdapterExtends = new TwoPlugAdapterExtends();
		NoteBook noteBook2 = new NoteBook(twoPlugAdapterExtends);
		noteBook2.charge();
	}
}












