package query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Customer;
import util.HibernateSessionFactory;

public class HqlQueryOrder {
	static Session session=HibernateSessionFactory.getSession();
	static Transaction tran=session.beginTransaction();
	//查询Customer全部数据
	//获取准测对象
	static Criteria crit=session.createCriteria(Customer.class);
	
	public static void main(String[] agrs){
		//降序
		//f1();
		//姓张的降序
		//f2();
		//?占位符
		//f3();
		//字符串类型数据占位
		f4();
	}

	private static void f4() {
		Query query=session.createQuery("from Customer where account<:a");
		query.setInteger("a", 222);
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

	private static void f3() {
		Query query=session.createQuery("from Customer where account<?");
		query.setInteger(0, 222);
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

	private static void f2() {
		Query query=session.createQuery("from Customer where cname like '张%' order by account desc");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

	private static void f1() {
		Query query=session.createQuery("from Customer order by account desc");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

}
