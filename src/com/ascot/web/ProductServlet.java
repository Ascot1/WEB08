package com.ascot.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ascot.domain.Product;
import com.ascot.service.AdminProductService;

public class ProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.传递请求到service层
		AdminProductService service = new AdminProductService();
		List<Product> productList = new ArrayList<Product>();
		productList = service.findAllProductService();
		
		//2.将list放入request中
		request.setAttribute("productList", productList);
		
		//3.将request发送到list.jsp中
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
