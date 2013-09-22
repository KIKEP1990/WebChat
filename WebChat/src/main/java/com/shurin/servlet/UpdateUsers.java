package com.shurin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.shurin.DAO.UserDao;
import com.shurin.DTO.UserDTO;

@WebServlet(name = "UpdateUsers", urlPatterns = "/UpdateUsers")
public class UpdateUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger LOG = Logger.getLogger(UpdateUsers.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String usersStr = "";
		UserDao userDao = new UserDao();
		Map<String, UserDTO> users = userDao.getUsers();
		Set<String> keys = users.keySet();
		for (String key : keys) {
			Calendar currentdate = Calendar.getInstance();
			users.get(key);
			if ((((currentdate.getTimeInMillis() / 1000) - (users.get(key)
					.getDate().getTimeInMillis() / 1000))) > 14) {
				users.remove(key);
				LOG.info("User " + key + " leave the chat");
			} else {
				String user = (String) request.getSession()
						.getAttribute("user");
				if (user.equals(key)) {
					usersStr += "<p><b>" + key + "</b></p>";
					continue;
				}
				usersStr += "<p>" + key + "</p>";

			}
		}

		try {
			PrintWriter writer = response.getWriter();
			writer.println(usersStr);
		} catch (IOException e) {
			LOG.error(e);
		}

	}
}
