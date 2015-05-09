package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		try {
			String password = request.getParameter("password");
			String no = request.getParameter("no");
			System.out.println(password+":"+no);
			GuestBookDao dao = new GuestBookDao();
			dao.guestBookDelete(no, password);
			response.sendRedirect("/mysite/views/guestbook/list.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
