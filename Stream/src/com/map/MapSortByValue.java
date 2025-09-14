package com.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 5);
		map.put("banana", 2);
		map.put("orange", 1);
		map.put("grape", 1);
		map.put("guava", 5);
		
		System.out.println("Sort By value Ascending");
		System.out.println(sortMapByValueAscending(map));
		
		System.out.println("Sort By value Decending");
		System.out.println(sortMapByValueDecending(map));

	}
	
	public static Map<String, Integer> sortMapByValueAscending(Map<String, Integer> map) {
		return map.entrySet().stream()
						.sorted(Map.Entry.comparingByValue())
						.collect(Collectors.toMap(
								Map.Entry :: getKey, 
								Map.Entry :: getValue,
								(oldVal, newVal) -> oldVal,
								LinkedHashMap :: new));
	}
	
	public static Map<String, Integer> sortMapByValueDecending(Map<String, Integer> map) {
		return map.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(
				Map.Entry :: getKey,
				Map.Entry :: getValue,
				(oldVal, newVal) -> oldVal,
				LinkedHashMap :: new));
	}	
}
