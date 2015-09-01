package team5.dao;

import java.sql.Connection;
import java.util.Date;

public class OrderDaoInsertTest {

	public static void main(String[] args) throws Exception{
		Order order = new Order();		
		order.setPayment("카드");
		order.setPrice(60000);
		order.setId("DAO");
		
		Connection conn = ConnectionManager.getConnection();
		OrderDao orderDao = new OrderDao(conn);
		Integer pk = orderDao.insert(order);
		if(pk!=null) {
			System.out.println(pk + "번 주문 완료^.^");
		} else {
			System.out.println("주문 실패 ㅠㅠ");
		}
		conn.close();
	}

}
