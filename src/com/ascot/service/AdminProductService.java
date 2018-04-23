package com.ascot.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ascot.dao.AdminProductDao;
import com.ascot.domain.Category;
import com.ascot.domain.Product;

public class AdminProductService {
	
	//1.获取数据库中所有商品数据并显示在页面中
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
	//传递数据
	public void addProductService(Product product) throws SQLException {
		// TODO Auto-generated method stub
		 dao.addProductDao(product);
	}
	public List<Category> addProductUIService() throws SQLException {
		// TODO Auto-generated method stub
		return dao.addProductUIDao();
	}
	public void delProductService(String pid) throws SQLException {
		// TODO Auto-generated method stub
		//传递数据到Dao层
		dao.delProductDao(pid);
	}
	
	
	


}
