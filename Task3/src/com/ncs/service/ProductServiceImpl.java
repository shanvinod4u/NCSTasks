package com.ncs.service;

import java.sql.SQLException;
import java.util.List;

import com.ncs.dao.ProductDao;
import com.ncs.dao.ProductDaoImpl;
import com.ncs.model.Products;

public class ProductServiceImpl implements ProductService{
	ProductDao prodDao;
	public ProductServiceImpl(){
		prodDao = new ProductDaoImpl();
	}
	@Override
	public List<Products> getAllProducts() throws SQLException {
		List<Products> products = prodDao.getAllProducts();
		return products;
	}
	@Override
	public List<Products> getProductsByPurchased(int id) throws SQLException {
		List<Products> products = prodDao.getProductsByPurchased(id);
		return products;
	}
	@Override
	public List<Products> searchProducts(String keyword) throws SQLException {
		List<Products> products = prodDao.searchProducts(keyword);
		return products;
	}

}
