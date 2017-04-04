package com.learn.basicSyntax.cardWash.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.learn.basicSyntax.cardWash.bean.Card;
import com.learn.basicSyntax.cardWash.bean.DeckCards;
import com.learn.basicSyntax.cardWash.bean.Person;

/*
 * 扑克相关操作类
 * 
 * */
public class DeckCardUtil {

	private DeckCards deckCards;  //扑克对象
	
    private Map<Integer, Person> persons; //玩家对象
    
    private Scanner scanner;
	
	public DeckCardUtil(){
		deckCards = new DeckCards();
		persons = new HashMap<Integer, Person>();
		scanner = new Scanner(System.in);
	}
	
	
	
	/*
	 * 创建一副扑克
	 * 
	 * */
	public void createDeckCards(){
		System.out.println("开始创建一副扑克牌...");
		String[] aFlowsString = {"红桃","方片","黑桃","梅花"};
		String[] aCardNumber = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		List<Card> cards = new ArrayList<Card>();
		for (String flowName: aFlowsString) {
			for (String numberName : aCardNumber) {
				cards.add(new Card(numberName,flowName));
			}
		}
		deckCards.setCards(cards);
		System.out.println("一副扑克牌创建结束");
	}
	
	
	/*
	 * 循环一副扑克牌内容
	 * 
	 * */
	public void forEacherDeckCards(){
		System.out.println("本副扑克牌有"+deckCards.getCards().size()+"张");
		if(deckCards.getCards().size()>=1){
			for (Card card : deckCards.getCards()) {
				System.out.print(card.getFlowerColor()+card.getNumber()+",");
			}
		}
	}
	
		
	/*
	 * 洗牌
	 * 
	 * */
	public void washCard(){
		System.out.println("开始洗牌...");
		List<Card> cards =  deckCards.getCards(); //获取已经有的一副牌
		List<Card> cards2 = new ArrayList<Card>(); //打乱后的一副牌
		//开始创建一副牌的随机生成范围
		do{
			int index = new Random().nextInt(cards.size());
			cards2.add(cards.remove(index));
		}while(cards.size()>0);
		deckCards.setCards(cards2);
		System.out.println("洗牌结束...");
	}
	
	/*
	 * 创建玩家
	 * 
	 * */
    public void createPerson(){
    	System.out.println("开始创建玩家信息：");
    	for(int i=0; i<2; i++){
    	    int personId = 0;
    	    do {
        	    try {
        	    	System.out.print("请输入玩家ID:");
        	    	personId = Integer.valueOf(scanner.next());
        	    	break;
    			} catch (Exception e) {
    				System.out.println("输入的不是整数类型.");
    				continue;
    			}				
			} while (personId<=0);
    	    System.out.print("请输入玩家名称:");
    	    String personName = scanner.next();
    	    Person person = new Person(Integer.valueOf(personId), personName); 
    	    persons.put(Integer.valueOf(personId), person);
    	}   
    	
        Set<Integer> personIds = persons.keySet();
    	for(Integer personId : personIds) {
			System.out.println("玩家"+persons.get(personId).getId()+":"+persons.get(personId).getName());
		}
    }
	
    
	/*
	 * 给玩家发牌
	 * 
	 * */
    public void sendCardPerson(){
    	System.out.println("开始给玩家发牌...");
    	//从后往前面发牌    	
    	for(int j=0; j<3; j++){    		
    		Set<Entry<Integer, Person>> personsEntry = persons.entrySet();
    		for (Entry<Integer, Person> entry : personsEntry) {
    			Card card = deckCards.getCards().remove(deckCards.getCards().size()-1);
    			Set<Card> personCard = entry.getValue().getCards();
    			personCard.add(card);
    			entry.getValue().setCards(personCard);
    			System.out.println(entry.getValue().getName()+"发一张牌");
			}
    	}
    }
	
	/*
	 * 显示玩家发的牌信息
	 * 
	 * */
    public void showCardForPerson(){
    	System.out.println("开始展示玩家发的扑克信息");
		Set<Entry<Integer, Person>> personsEntry = persons.entrySet();
		for (Entry<Integer, Person> entry : personsEntry) {
			Person person = entry.getValue();
			System.out.print(person.getName()+"发到的扑克是:");
			for (Card card : person.getCards()) {
				System.out.print(card.getFlowerColor()+card.getNumber()+",");
			}
			System.out.println("");
		}
    }
	
	
}
