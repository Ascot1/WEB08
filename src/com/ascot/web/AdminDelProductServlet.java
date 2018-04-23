package com.ascot.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ascot.service.AdminProductService;


public class AdminDelProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //获取请求的参数
		String pid = request.getParameter("pid");
	  //将获得的参数传递到Service层
		AdminProductService service = new AdminProductService();
		try {
			service.delProductService(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//跳转到展示界面
		response.sendRedirect(request.getContextPath()+"/productServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
