package com.ascot.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ascot.dao.AdminProductDao;
import com.ascot.domain.Product;

public class AdminProductService {
	
	AdminProductDao dao = new AdminProductDao();
	List <Product> list = new ArrayList<Product>();
	public List<Product> findAllProductService(){
		try {
			 list = dao.findAllProductDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
