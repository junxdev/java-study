package com.bit.day21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class Ex14EntryAndMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<>();
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		
		System.out.println(map.get("key1"));
		
		Set<String> keys = map.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			String key = ite.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		Set<Entry<String, String>> entrys = map.entrySet(); // map¿∫ entry¿« set 
		Iterator<Entry<String, String>> ite2 = entrys.iterator();
		while(ite2.hasNext()) {
			Entry<String, String> entry = ite2.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
	}

}
