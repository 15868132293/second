package com.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.biz.Iuserbiz;
import com.dao.Iuserdao;
import com.dao.impl.UserDaoimpl;
import com.entity.Student;


public class Userbizimpl implements Iuserbiz {

	private Iuserdao udao=new UserDaoimpl();
	
	@Override
	public List findAll() {
		List ulist = new ArrayList();
		ulist = udao.ufindAll();
		return ulist;
	}

	@Override
	public List doadd(Student stu) {
		List ulist = new ArrayList();
		ulist = udao.doadd(stu);
		return ulist;
		
	}

	@Override
	public List delete(int sid) {
		List ulist = new ArrayList();
		ulist = udao.dodelete(sid);
		return ulist;
	}

	@Override
	public List toupdate(int sid) {
		List ulist = new ArrayList();
		ulist = udao.toupdate(sid);
		return ulist;
	}

	@Override
	public List doupdate(Student stu) {
		List ulist = new ArrayList();
		ulist = udao.doupdate(stu);
		return ulist;
	}

	@Override
	public int count() {
		int count = 0 ;
		count = udao.count();
		return count;
	}
	

}
