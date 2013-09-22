package com.shurin.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shurin.DAO.UserDao;
import com.shurin.DTO.MessageDTO;

@WebServlet(name = "QuestionHandler", urlPatterns = "/QuestionHandler")
public class QuestionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(LoginHandler.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String message = request.getParameter("message");
		String mesDateLogin;
		String user = (String) request.getSession().getAttribute("user");
		UserDao userDao = new UserDao();
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String time = formatter.format(currentDate.getTime());
		mesDateLogin = "[" + time + "]" + " " + user + ": " + message;
		MessageDTO fullMessage = new MessageDTO(mesDateLogin, currentDate);
		if (userDao.getMessageList().size() > 100) {
			userDao.getMessageList().remove(0);
		}
		userDao.addMessage(fullMessage);
		formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		time = formatter.format(currentDate.getTime());
		LOG.info(time + " " + user + " sent the message: " + message);
	}

}
