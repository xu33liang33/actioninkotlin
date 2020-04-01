package chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LambbdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		
		list.add("d");
		list.add("e");
		list.add("f");
		
		List<String> list1 = list.subList(0, 3);
		List<String> list2 = list.subList(0, 6);

		
		System.out.println(list);
		
		System.out.println(list1);
		
		System.out.println(list2);
		
		String.valueOf(null + "");
		
		
		
		Map<String, String> map = new LinkedHashMap<String, String>();

	     map.put("a3", "aa");       

	     map.put("a2", "bb"); 

	     map.put("b1", "cc"); 

	     for (Iterator iterator = map.values().iterator(); iterator.hasNext();) {           

	             String name = (String) iterator.next(); 

	             System.out.println(name);     

	     }
		
	}

}
