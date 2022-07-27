package com.example.batch.tmp;

import java.util.List;
import java.util.Map;

public class test {
	
	private static test2 t2 = new test2();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		test t1 = new test();
		t1.test_func1();
		t1.test_func2();
	}
	
	public void test_func1() {		
		t2.func2();		
	}
	
	public void test_func2() {
		//값 참조용
		//test2 t2 = new test2();
		List<Map<String, Object>> listMap = t2.getListMap();
		
		for( int i= 0; i < listMap.size(); i++) {
			
			System.out.print(listMap.get(i).get("name")+",");
			System.out.print(listMap.get(i).get("age")+",");
			System.out.println(listMap.get(i).get("status"));
		}		
	}

}
