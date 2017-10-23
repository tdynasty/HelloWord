package qbc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest6 {

	public static void main(String[] args) {
		//查询单条记录
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		//获取准测对象
		Criteria crit=session.createCriteria(Customer.class);
		//从第二条数据的下一跳
		crit.setFirstResult(2);
		crit.setMaxResults(1);
		Customer cus=(Customer) crit.uniqueResult();
		
		
		System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		tran.commit();
		HibernateSessionFactory.closeSession();

	}
	

}
