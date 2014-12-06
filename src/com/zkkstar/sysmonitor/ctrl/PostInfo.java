package com.zkkstar.sysmonitor.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PostInfo")
public class PostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String[]> map = request.getParameterMap();
		for (String key : map.keySet()) {
			try{
				System.out.println(key + ":>" + new String(Base64.decode(map.get(key)[0].toString())));
			}catch(Exception e)
			{
				System.out.println("key error:" + key);
			}
		}
		response.getWriter().write("Server got it.");
	}

}
