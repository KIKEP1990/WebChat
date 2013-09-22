package com.shurin.servlet;

import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shurin.DAO.UserDao;

@WebServlet(name = "CheckOnline", urlPatterns = "/CheckOnline")
public class CheckOnline extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		UserDao userDao = new UserDao();
		HttpSession session = request.getSession(true);
		Calendar currentdate = Calendar.getInstance();
		Calendar date = userDao.getUsers().get(session.getAttribute("user"))
				.getDate();
		date.setTimeInMillis(currentdate.getTimeInMillis());

	}

}
