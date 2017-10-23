package qbc;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest {

	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//��ѯCustomerȫ������
		Criteria crit=session.createCriteria(Customer.class);
		
		List<Customer> list=crit.list();
		//�������������ַ�����
		
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
//		
		//for(���� ����:����򼯺�)
//		for(Customer cus:list){
//			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
//		}
		
		//������Iterator
//		Iterator<Customer> itea=list.iterator();
//		while(itea.hasNext()){
//			Customer cus=(Customer) (itea=list.iterator());
//			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
//		}
		
		
		
		tran.commit();
		HibernateSessionFactory.closeSession();

	}

}
