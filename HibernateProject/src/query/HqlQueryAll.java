package query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Customer;
import util.HibernateSessionFactory;

public class HqlQueryAll {
	static Session session=HibernateSessionFactory.getSession();
	static Transaction tran=session.beginTransaction();
	//查询Customer全部数据
	//获取准测对象
	static Criteria crit=session.createCriteria(Customer.class);
	
	public static void main(String[] agrs){
		//查询所有
		f1();
		//查询名字
		//f2();
		//查询Customer cname cbalance 应用别名
		//f3();
		//条件查询
		//f4();
		//between
		//f5();
		//不在222和444之间
		//f6();
		//不是姓张的
		//f7();
		//
		//f8();
		//
		//f9();
	}
	private static void f9() {
		// TODO Auto-generated method stub
		
	}
	private static void f8() {
		Query query=session.createQuery("from Customer where cname ='张三' and ");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}
	private static void f7() {
		Query query=session.createQuery("from Customer where cname not like '张%'");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}
	private static void f6() {
		Query query=session.createQuery("from Customer where account not between 222 and 444");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();		
	}
	private static void f1() {
		//查询全部Customer全部信息
			Query query=session.createQuery("from Customer");
			List<Customer> list=query.list();
			for(Customer cus:list){
				System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
			}
			
			tran.commit();
			HibernateSessionFactory.closeSession();
		
	}
	public static void f2(){
		Query query=session.createQuery("select cname from Customer");
		List<String> list=query.list();
		for(String cname:list){
			System.out.println(cname);
		}
		tran.commit();
		HibernateSessionFactory.closeSession();
	}
	private static void f3() {
		Query query=session.createQuery("select cus.cname,cus.cbalance from Customer as cus");
		List<Object[]> list=query.list();
		for(Object[] obj:list){
			System.out.println(obj[0]+"  "+obj[1]);
		}
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}
	private static void f4() {
		Query query=session.createQuery("from Customer where cname like '张%'");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}
	private static void f5() {
		Query query=session.createQuery("from Customer where account between 222 and 555");
		List<Customer> list=query.list();
		for(Customer cus:list){
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}
		
		tran.commit();
		HibernateSessionFactory.closeSession();
		
	}

}
