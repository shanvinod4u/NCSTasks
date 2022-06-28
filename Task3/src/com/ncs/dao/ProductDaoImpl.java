package com.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ncs.model.Products;

public class ProductDaoImpl implements ProductDao {
	
	Connection con; 
	
	public ProductDaoImpl() {
		con = MySQLConnection.mySql;
			}

	@Override
	public List<Products> getAllProducts() throws SQLException {
		List<Products> products = new ArrayList<>();
		String query = "select * from products";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Products p = new Products();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setProductPrice(rs.getInt("productPrice"));
				p.setPurchasedBy(rs.getInt("purchasedBy"));
				products.add(p);
			}		
				
		return products;
	}

	@Override
	public List<Products> getProductsByPurchased(int id) throws SQLException {
		List<Products> products = new ArrayList<>();
		String query = "select * from products where purchasedBy = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Products p = new Products();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setProductPrice(rs.getInt("productPrice"));
				p.setPurchasedBy(rs.getInt("purchasedBy"));
				products.add(p);
			}		
		return products;
	}

	@Override
	public List<Products> searchProducts(String keyword) throws SQLException {
		List<Products> products = new ArrayList<>();
		String query = "select * from products where productName like '%' ? '%' ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Products p = new Products();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString("productName"));
				p.setProductPrice(rs.getInt("productPrice"));
				p.setPurchasedBy(rs.getInt("purchasedBy"));
				products.add(p);
			}		
		return products;
	}

}
