package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dao.Iuserdao;
import com.entity.Student;
import com.util.JdbcUtils;

public class UserDaoimpl implements Iuserdao {
	public List ufindAll() {
		List dlist = JdbcUtils.query("select * from student,classes where class_id=classid");
		List list = new ArrayList();
		for (Object obj : dlist) {
			list.add(JSON.parseObject(JSON.toJSONString(obj), Student.class));
		}
		return list;
	}

	@Override
	public List doadd(Student stu) {
		JdbcUtils.update("insert into student(studentname,class_id) values(?,?) ", new Object[]{stu.getStudentname(),stu.getClass_id()});
		
		return this.ufindAll();
	}

	@Override
	public List dodelete(int sid) {
		JdbcUtils.update("delete from student where studentid=?", new Object[]{sid});
		return this.ufindAll();
	}

	@Override
	public List toupdate(int sid) {
		List dlist = JdbcUtils.query(" select * from student where studentid=?", new Object[]{sid});
		List  list = new ArrayList();
		for (Object obj : dlist) {
			list.add(JSON.parseObject(JSON.toJSONString(obj), Student.class));
		}
		return list;
	}

	@Override
	public List doupdate(Student stu) {
		JdbcUtils.update("update student set studentname=?,class_id=? where studentid=?", new Object[]{stu.getStudentname(),stu.getClass_id(),stu.getStudentid()});
		return this.ufindAll();
	}

	@Override
	public int count() {
		List list = JdbcUtils.query("select * from student");
		return list.size();
	}
}
