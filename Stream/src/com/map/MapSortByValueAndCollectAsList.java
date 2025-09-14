package com.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValueAndCollectAsList {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 5);
		map.put("banana", 2);
		map.put("orange", 1);
		map.put("grape", 1);
		map.put("guava", 5);
		
		System.out.println("Sort By value Ascending List");
		System.out.println(sortMapByValueAscending(map));
		
		System.out.println("Sort By value Decending List");
		System.out.println(sortMapByValueDecending(map));

	}
	
	public static Map<Integer, List<String>> sortMapByValueAscending(Map<String, Integer> map) {
		return map.entrySet().stream()
						.sorted(Map.Entry.comparingByValue())
						.collect(Collectors.groupingBy( 
								Map.Entry :: getValue,
								LinkedHashMap ::new,
								Collectors.mapping(Map.Entry :: getKey, Collectors.toList())
								));
	}
	
	public static Map<Integer, List<String>> sortMapByValueDecending(Map<String, Integer> map) {
		Map<Integer, List<String>> mapSorted =  map.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.groupingBy(
				Map.Entry :: getValue,
				LinkedHashMap::new,
				Collectors.mapping(Map.Entry :: getKey, Collectors.toList())
				));
		
		mapSorted.forEach((k, v) -> Collections.sort(v));
		
		return mapSorted;
	}	
}
