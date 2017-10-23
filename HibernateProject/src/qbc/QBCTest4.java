package qbc;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest4 {

	public static void main(String[] args) {
		//��ѯ������cname ��% �� account 333-555
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//��ѯCustomerȫ������
		//��ȡ׼�����
		Criteria crit=session.createCriteria(Customer.class);
		//Restrictions���ص���Criterion����
		Criterion con=Restrictions.or(Restrictions.like("cname", "��%"), Restrictions.between("account", 222, 555));
		
		//��ѯ�������뵽׼�������
		crit.add(con);
		
		List<Customer> list=crit.list();
		
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}

	}

}
