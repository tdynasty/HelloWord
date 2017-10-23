package qbc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest2 {

	public static void main(String[] args) {
		//��ѯ���ʴ��ڵ���3000��������Ϣ
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		//1����ȡ׼�����
		//Criteria crit=session.createCriteria(Customer.class);
		//2�����ݹ������ȡ��ѯ�������� �����ࣺrestriction
		
		
		//Criterion con1=Restrictions.ge("cbalance",2000.0);//׼ȷֵ��ѯ
		//like
		//Criterion con2=Restrictions.like("cname", "��%");
		//between
		//Criterion con3=Restrictions.between("account",0,222);
		
		
		
		//3���Ѳ�ѯ�������뵽׼�������
		//crit.add(con1);
		//crit.add(con2);
		//crit.add(con3);
		
		
		//��������̷��
		List list=session.createCriteria(Customer.class)
				.add(Restrictions.ge("cbalance",2000.0))
				.add(Restrictions.like("cname", "��%"))
				.add(Restrictions.between("account",000,444)).list();
				
		//List<Customer> list=crit.list();
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getCname()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
