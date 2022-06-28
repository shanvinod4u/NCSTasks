package com.ncs.dao;

import java.sql.SQLException;
import java.util.List;

import com.ncs.model.Products;

public interface ProductDao {
	
	public List<Products> getAllProducts()throws SQLException;
	List<Products> getProductsByPurchased(int id)throws SQLException;
	List<Products> searchProducts(String keyword)throws SQLException;

}
