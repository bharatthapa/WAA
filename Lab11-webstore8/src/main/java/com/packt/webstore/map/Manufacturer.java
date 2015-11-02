package com.packt.webstore.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Manufacturer {

	Map<String, List<String>> map = new HashMap<String, List<String>>();

	public Manufacturer() {
		List<String> googleList = new ArrayList<>();
		googleList.add("Tablet");
		map.put("Google", googleList);
		List<String> dellList = new ArrayList<>();
		dellList.add("Laptop");
		map.put("Dell", dellList);
		List<String> appleList = new ArrayList<>();
		appleList.add("Smart Phone");
		map.put("Apple", appleList);
	}

	public List<String> getAllManufacturer() {
		return new ArrayList<String>(map.keySet());
	}

	public List<String> getCategoriesByManufacturer(String manufacturer) {
		return map.get(manufacturer);
	}
}
