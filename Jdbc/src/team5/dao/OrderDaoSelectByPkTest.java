package team5.dao;

import java.sql.Connection;

public class OrderDaoSelectByPkTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		OrderDao orderDao = new OrderDao(conn);
		Order order = orderDao.selectByPk(4);
		if(order != null) {
			System.out.println("번호: " + order.getNo());
			System.out.println("주문자: " + order.getId());
			System.out.println("주문일시: " + order.getDate());
			System.out.println("결제방법: " + order.getPayment());
			System.out.println("주문액: " + order.getPrice());
		} else {
			System.out.println(4 + "번 주문이 존재하지 않습니다 ㅠㅠ");
		}
		conn.close();

	}

}
