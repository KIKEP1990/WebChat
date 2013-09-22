package com.shurin.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.shurin.DAO.UserDao;
import com.shurin.DTO.UserDTO;
import com.shurin.utils.Utils;

@WebServlet(name = "LoginHandler", urlPatterns = "/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(LoginHandler.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDao userDao = new UserDao();
		if (Utils.isIdSessionUsed(userDao, session)) {
			redirect("index.jsp", "error", "You already chatting", request,
					response);
			return;
		}
		String name = request.getParameter("user");
		if (userDao.getUsers().containsKey(name)) {
			redirect("index.jsp", "error", "This login is used", request,
					response);
			return;
		}
		Calendar date = Calendar.getInstance();
		session.setAttribute("time", date.getTimeInMillis());
		LOG.info("User "+name+" successfully login into the chat");
		UserDTO userData = new UserDTO(date, session.getId());
		session.setAttribute("user", name);
		userDao.addUser(name, userData);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("chat.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOG.error(e);
		}

	}

	public void redirect(String url, String attributeName,
			String attrebuteValue, HttpServletRequest request,
			HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		request.setAttribute(attributeName, attrebuteValue);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			LOG.error(e);
		}
	}

}
