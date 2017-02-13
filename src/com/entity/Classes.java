package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Classes {

	private int classid;
	private String classname;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public Classes(int classid, String classname) {
		super();
		this.classid = classid;
		this.classname = classname;
	}
	public Classes() {
		super();
	}
	
}
