package team5.dao;

import java.sql.Connection;

public class OrderDaoSelectByPkTest {

	public static void main(String[] args) throws Exception {
		
		Connection conn = ConnectionManager.getConnection();
		OrderDao orderDao = new OrderDao(conn);
		Order order = orderDao.selectByPk(4);
		if(order != null) {
			System.out.println("��ȣ: " + order.getNo());
			System.out.println("�ֹ���: " + order.getId());
			System.out.println("�ֹ��Ͻ�: " + order.getDate());
			System.out.println("�������: " + order.getPayment());
			System.out.println("�ֹ���: " + order.getPrice());
		} else {
			System.out.println(4 + "�� �ֹ��� �������� �ʽ��ϴ� �Ф�");
		}
		conn.close();

	}

}
