package query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Customer;
import util.HibernateSessionFactory;

public class HqlQueryTJ {

	static Session session=HibernateSessionFactory.getSession();
	static Transaction tran=session.beginTransaction();
	//查询Customer全部数据
	//获取准测对象
	static Criteria crit=session.createCriteria(Customer.class);
	public static void main(String[] args) {
		//统计最大值
		//f1();
		//
		f2();
	}
	private static void f2() {
		Query query=session.createQuery("select max(account),min(account),avg(cbalance),sum(cbalance) from Customer");
		Object[] obj=(Object[]) query.uniqueResult();
		System.out.println(obj[0]);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}
	private static void f1() {
		Query query=session.createQuery("select max(account) from Customer");
		Integer maxValue=(Integer) query.uniqueResult();
		System.out.println(maxValue);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

}
