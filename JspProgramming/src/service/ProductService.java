package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionManager;
import dao.ProductDao;
import dto.Product;

public class ProductService {
   public void insert(Product product){
      Connection conn = null;
      
      try {
         conn = ConnectionManager.getConnection();
         ProductDao pdao = new ProductDao(conn);
         pdao.insert(product);
      } catch (ClassNotFoundException e) {         
         e.printStackTrace();
      } catch (SQLException e) {         
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {            
            e.printStackTrace();
         }
      }
   }
   
   public List<Product> getPage(int pageNo, int rowsPerPage){
      Connection conn = null;
      List<Product> list = new ArrayList<Product>();
      
      try {   
         conn = ConnectionManager.getConnection();
         ProductDao productdao = new ProductDao(conn);
         list = productdao.selectBypage(pageNo,rowsPerPage);
         
      } catch (ClassNotFoundException e) {         
         e.printStackTrace();
      } catch (SQLException e) {         
         e.printStackTrace();
      }finally {
         try {
            conn.close();
         } catch (SQLException e) {            
            e.printStackTrace();
         }
      }
      return list;
   }
   public Product getProduct(int productNo) {
		Product product = null;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao productDao = new ProductDao(conn);
			product = productDao.selectbyPk(productNo);
		} catch (Exception e) {			
			e.printStackTrace();		
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
		return product;
	}
   public void modify(Product product) {		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao productDao = new ProductDao(conn);
			productDao.update(product);
		} catch (Exception e) {			
			e.printStackTrace();
			System.out.println(product.getName());
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
		
	}
   public void remove(int productNo) {		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao productDao = new ProductDao(conn);
			productDao.delete(productNo);
		} catch (Exception e) {			
			e.printStackTrace();		
		} finally {
			try { conn.close(); } catch (SQLException e) {}
		}
		
	}
}