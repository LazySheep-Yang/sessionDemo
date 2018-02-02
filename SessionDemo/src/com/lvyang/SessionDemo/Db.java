package com.lvyang.SessionDemo;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class Db {

	private static List<User> list=new ArrayList<User>();
	
	
	static{
		list.add(new User("aaa","11"));
		list.add(new User("aaa","22"));
		list.add(new User("aaa","33"));
		list.add(new User("aaa","44"));
	}
	public static List<User> getList() {
		return list;
	}
}
