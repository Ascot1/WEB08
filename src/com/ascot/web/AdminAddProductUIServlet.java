package com.ascot.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ascot.domain.Category;
import com.ascot.service.AdminProductService;

/**
 * Servlet implementation class AdminAddProductUIServlet
 */
public class AdminAddProductUIServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 
		 //1.返回category数据
		 AdminProductService service = new AdminProductService();
		 List<Category> category = null;
		 try {
			category = service.addProductUIService();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("categoryList", category);
		 request.getRequestDispatcher("/admin/product/add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
