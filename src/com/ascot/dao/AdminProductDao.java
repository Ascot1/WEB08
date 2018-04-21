package com.ascot.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ascot.domain.Category;
import com.ascot.domain.Product;
import com.ascot.utils.DataSourceUtils;

public class AdminProductDao {

	public List<Product> findAllProductDao() throws SQLException{
		List<Product> list = new ArrayList<Product>();
		//1.连接数据库
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//2.编写sql语句
		String sql ="select * from product";
		//3.执行sql语句
		list = qr.query(sql, new BeanListHandler<Product>(Product.class));
		//4.返回数据
		return list;
	}

	public void addProductDao(Product product) throws SQLException {
		// TODO Auto-generated method stub	
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product value (?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
				  product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),
				  product.getFlag(),product.getCid());
	}

	public List<Category> addProductUIDao() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categorys =  qr.query(sql, new BeanListHandler<Category>(Category.class));
		return categorys;
	}
	
}
