package collection;

import java.util.ArrayList;
import java.util.Collections;

public class Test01 {

	public static void main(String[] args) {
		ArrayList<String> pk=new ArrayList<>();
		String[] colors= {"♥","♠","♣","♦"};
		String[] numbers= {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		pk.add("大王");
		pk.add("小王");
		for(String color:colors) {
			for(String number:numbers) {
				pk.add(color+number);
			}
		}
		//System.out.print(pk);
		Collections.shuffle(pk);
		//System.out.print(pk);
		ArrayList<String> person1=new ArrayList<>();
		ArrayList<String> person2=new ArrayList<>();
		ArrayList<String> person3=new ArrayList<>();
		ArrayList<String> diPai=new ArrayList<>();
		
		for(int i=0;i<pk.size();i++) {
			String p=pk.get(i);
			if(i>50) {
				diPai.add(p);
			}
			else if(i%3==0) {
				person1.add(p);
			}
			else if(i%3==1) {
				person2.add(p);
			}
			else if(i%3==2) {
				person3.add(p);
			}
		}
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(person3);
		System.out.println(diPai);
		
	}

}
