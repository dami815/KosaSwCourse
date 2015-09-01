package team5.dao;

import java.sql.Connection;
import java.util.Date;

public class OrderDaoInsertTest {

	public static void main(String[] args) throws Exception{
		Order order = new Order();		
		order.setPayment("ī��");
		order.setPrice(60000);
		order.setId("DAO");
		
		Connection conn = ConnectionManager.getConnection();
		OrderDao orderDao = new OrderDao(conn);
		Integer pk = orderDao.insert(order);
		if(pk!=null) {
			System.out.println(pk + "�� �ֹ� �Ϸ�^.^");
		} else {
			System.out.println("�ֹ� ���� �Ф�");
		}
		conn.close();
	}

}
