package com.ascot.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ascot.domain.Product;
import com.ascot.service.AdminProductService;


public class AdminAddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2，封装数据
		Product  product = new Product();
		try {
			BeanUtils.populate(product, properties);
		} catch(Exception e){
			e.printStackTrace();
		}
		//3.手动设置表单中没有的数据
		//(1)private String pid;
		product.setPid(UUID.randomUUID().toString());
		//(2)private String pimage;
		product.setPimage("products/1/c_0033.jpg");
		//(3)private String pdate;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = format.format(new Date());
		product.setPdate(pdate);
		//(4)private int pflag;
		product.setFlag(0);
		//4.传递数据到service层
		AdminProductService service = new AdminProductService();
		try {
			service.addProductService(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//5.将数据传到list.jsp中
		response.sendRedirect(request.getContextPath()+"/productServlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
