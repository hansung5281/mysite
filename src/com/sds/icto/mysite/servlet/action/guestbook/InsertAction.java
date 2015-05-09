package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			GuestBookVo vo = new GuestBookVo();
			
			String name = request.getParameter("name");
			String password = request.getParameter("pass");	
			String content = request.getParameter("content");
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(content);
			
			GuestBookDao dao = new GuestBookDao();
			dao.guestBookInsert(vo);
			WebUtil.forward("/views/guestbook/list.jsp", request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
