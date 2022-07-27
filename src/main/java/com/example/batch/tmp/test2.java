package com.example.batch.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2 {
	
	private List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>(); 

	public void func2 () {

		for(int i=1; i<=3; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", "value"+i);
			map.put("age", i);
			map.put("status", "status"+1);
			
			listMap.add(map);
		}	 
	}

	public List<Map<String, Object>> getListMap() {
		return listMap;
	}	

}
