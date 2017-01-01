package edu.home.string;

import java.util.ArrayList;
import java.util.List;

final class ImmutableClass {

	private final int id;

	private final List<String> list;

	/*Constructor performing Shallow Copy
	public ImmutableClass(int id, List<String> list) {
		this.id = id;
		this.list = list;
	}*/
	
	/**
     * Constructor performing Deep Copy
     */
	public ImmutableClass(int id, List<String> list) {
		this.id = id;
		List<String> tempList = new ArrayList<>();
		for (String string : list) {
			tempList.add(string);
		}
		this.list = tempList;
	}

	public final int getId() {
		return id;
	}

	public final List<String> getList() {
		return   new ArrayList<>(list);
	}

}

public final class ImmutableClassTest {
	
	public static void main(String[] args){
		
		List<String> list = new ArrayList<>();
		list.add("ABC");
		
		ImmutableClass immutableClass = new ImmutableClass(1, list);
		list.add("DEF");
		
		//System.out.println(immutableClass.getList());
		
		immutableClass.getList().add("EFG");
		
		System.out.println(immutableClass.getList());
		
	}

}
