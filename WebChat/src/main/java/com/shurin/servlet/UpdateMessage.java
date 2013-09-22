package com.shurin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shurin.DAO.UserDao;
import com.shurin.DTO.MessageDTO;

@WebServlet(name = "UpdateMessage", urlPatterns = "/UpdateMessage")
public class UpdateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG=Logger.getLogger(UpdateMessage.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String result = "";
		UserDao userDao = new UserDao();
		List<MessageDTO> message = userDao.getMessageList();
		Iterator<MessageDTO> iterator = message.iterator();
		long timeAddedToChat = (long) request.getSession().getAttribute("time");
		while (iterator.hasNext()) {
			MessageDTO currentMessage = iterator.next();
			if (currentMessage.getDate().getTimeInMillis()>timeAddedToChat) {
				result += currentMessage.getMessage() + "<br>";
			}
		}
		try {
			PrintWriter writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			LOG.error(e);
		}
	}

}
