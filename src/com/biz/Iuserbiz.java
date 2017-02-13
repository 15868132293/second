package com.biz;

import java.util.List;

import com.entity.Student;



public interface Iuserbiz {


	public List findAll();

	public List doadd(Student stu);

	public List delete(int sid);

	public List toupdate(int sid);

	public List doupdate(Student stu);

	public int  count();

	
}
