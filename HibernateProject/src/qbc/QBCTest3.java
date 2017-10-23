package qbc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest3 {

	public static void main(String[] args) {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		//1����ȡ׼�����
		Criteria crit=session.createCriteria(Customer.class);
		//2�����Order����
		Order order = Order.desc("account");
		//�ӵڼ�������ʼ��
		crit.setFirstResult(1);
		crit.setMaxResults(1);
		List<Customer> list=crit.addOrder(order).list();
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getAccount()+cus.getCname()+cus.getCbalance());
		}
		
		
		
		tran.commit();
		HibernateSessionFactory.closeSession();

	}

}
