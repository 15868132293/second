package com.entity;

public class Student {

	private int studentid;
	private String studentname;
	private int class_id;
	private String classname;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Student(int studentid, String studentname, int class_id) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.class_id = class_id;
	}
	public Student(int studentid, String studentname, int class_id, String classname) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.class_id = class_id;
		this.classname = classname;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getClass_id() {
		return class_id;
	}
	public Student(String studentname, int class_id) {
		super();
		this.studentname = studentname;
		this.class_id = class_id;
	}
	public Student() {
		super();
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
}
