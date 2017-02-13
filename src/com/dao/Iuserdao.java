package com.dao;

import java.util.List;

import com.entity.Student;



public interface Iuserdao {

	
	public List ufindAll();

	public List doadd(Student stu);

	public List dodelete(int sid);

	public List toupdate(int sid);

	public List doupdate(Student stu);

	public int count();



	


}
