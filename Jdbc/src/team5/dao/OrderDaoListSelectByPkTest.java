package team5.dao;

import java.sql.Connection;
import java.util.List;

public class OrderDaoListSelectByPkTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		OrderDao orderDao = new OrderDao(conn);
		List<Order> list = orderDao.selectByPk("DAO");
		for(Order order: list) {
			System.out.println("�ֹ���ȣ: " + order.getNo());
			System.out.println("�ֹ���: " + order.getId());			
			System.out.println("�ֹ���: " + order.getPrice() + "��");	
		}
		conn.close();

	}

}
