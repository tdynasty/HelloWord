package qbc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest7 {
	public static void main(String[] args) {
		//ͳ�ƺ���
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//��ѯCustomerȫ������
		//��ȡ׼�����
		Criteria crit=session.createCriteria(Customer.class);
		//ͳ��cbalanceƽ��ֵ
		//Projections�൱�ڹ��� ��������
		//Projection po=Projections.avg("cbalance");
		//crit.setProjection(po);
		//Double avgcbalance=(Double) crit.uniqueResult();
		//ͳ�ƺ������뵽׼�������
		//ͳ�ƴ�balance�����ֵ
		Projection po1=Projections.max("cbalance");
		crit.setProjection(po1);
		Double maxcbalance=(Double) crit.uniqueResult();
		
		//System.out.println(avgcbalance);
		System.out.println(maxcbalance);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
