package ArrayListTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<6;i++) {
			Integer num=random.nextInt(33)+1;
			list.add(num);
		}
//		for(int j=0;j<list.size();j++) {
//			System.out.print(list.get(j)+" ");
//		}
		HashSet h=new HashSet();
		h.add(list);
		Iterator it=h.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
	}

}
