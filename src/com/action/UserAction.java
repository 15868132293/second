/**
 * 
 */
package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.Iuserbiz;
import com.biz.impl.Userbizimpl;
import com.entity.Student;


/**
 * @author Administrator
 *
 */
public class UserAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String flag =req.getParameter("flag");
		HttpSession session = req.getSession();
		Iuserbiz ub = new  Userbizimpl();
		int count = ub.count();//一共有多少个
		req.setAttribute("count", count);
		int pagenum = count/2;//页数
		req.setAttribute("pagenum", pagenum);
		StringBuffer sb = new StringBuffer(); // 实例化StringBuffer
        for (int i = 1; i <= pagenum; i++) { // 通过循环构建分页导航条
            if (i == pagenum+1) { // 判断是否为当前页
                sb.append("『" + i + "』"); // 构建分页导航条
            } else {
                // 构建分页导航条
                sb.append("<a href='UserAction?flag=jump" + i + "'>" + i + "</a>");
            }
            sb.append("　"); // 构建分页导航条
        }
        req.setAttribute("bar", sb.toString()); // 将分页导航条的字符串放置到request中
		
		
		if(flag==null){
		List list = ub.findAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("message.jsp").forward(req, resp);
		}else if(flag.equals("doAdd")){
			String studengname = req.getParameter("studentname");
			int class_id = Integer.parseInt(req.getParameter("calss_id"));
			Student stu = new Student(studengname,class_id);
			List list = ub.doadd(stu);
			req.setAttribute("list", list);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		}else if(flag.equals("delete")){
			int sid = Integer.parseInt(req.getParameter("studentid"));
			List list = ub.delete(sid);
			req.setAttribute("list", list);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		}else if(flag.equals("toupdate")){
			int sid = Integer.parseInt(req.getParameter("studentid"));
			List list = ub.toupdate(sid);
			req.setAttribute("list", list);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}else if(flag.equals("doupdate")){
			int classid =Integer.parseInt(req.getParameter("classid"));
			String studentname = req.getParameter("studentname");
			Student stu = new Student(studentname,classid);
			List list = ub.doupdate(stu);
			req.setAttribute("list", list);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
			
		}else if(flag.equals("page")){
			
			int page =Integer.parseInt(req.getParameter("page"));
			if(page<1){
			req.getRequestDispatcher("warn.jsp").forward(req, resp);	
			}else if(page>pagenum){
			req.getRequestDispatcher("warn.jsp").forward(req, resp);	
			}else{
			session.setAttribute("pagelast", page-1);
			session.setAttribute("pagenext", page+1);
			List list=new ArrayList<>();
			List list1 = ub.findAll();
			for (int i = 2*(page-1);i<2*page;i++) {
				list.add(list1.get(i));
			}
			req.setAttribute("list", list);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
			}
		}else if(flag.startsWith("jump")){
			int page = Integer.parseInt(flag.substring(4));
			if(page<1){
				page=1;
				session.setAttribute("pagelast", page-1);
				session.setAttribute("pagenext", page+1);
				List list=new ArrayList<>();
				List list1 = ub.findAll();
				for (int i = 2*(page-1);i<2*page;i++) {
					list.add(list1.get(i));
				}
				req.setAttribute("list", list);
				req.getRequestDispatcher("message.jsp").forward(req, resp);
			}else if(page<=pagenum){
			session.setAttribute("pagelast", page-1);
			session.setAttribute("pagenext", page+1);
			List list=new ArrayList<>();
			List list1 = ub.findAll();
			for (int i = 2*(page-1);i<2*page;i++) {
				list.add(list1.get(i));
			}
			req.setAttribute("list", list);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
			}else{
				page=pagenum;
				session.setAttribute("pagelast", page-1);
				session.setAttribute("pagenext", page+1);
				List list=new ArrayList<>();
				List list1 = ub.findAll();
				for (int i = 2*(page-1);i<2*page;i++) {
					list.add(list1.get(i));
				}
				req.setAttribute("list", list);
				req.getRequestDispatcher("message.jsp").forward(req, resp);
			}
		}


	}
}
