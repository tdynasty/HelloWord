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
		//查询工资大于等于3000所有人信息
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		//1、获取准则对象
		//Criteria crit=session.createCriteria(Customer.class);
		//2、根据工具类获取查询条件对象 工具类：restriction
		
		
		//Criterion con1=Restrictions.ge("cbalance",2000.0);//准确值查询
		//like
		//Criterion con2=Restrictions.like("cname", "张%");
		//between
		//Criterion con3=Restrictions.between("account",0,222);
		
		
		
		//3、把查询条件加入到准则对象当中
		//crit.add(con1);
		//crit.add(con2);
		//crit.add(con3);
		
		
		//方法链编程风格
		List list=session.createCriteria(Customer.class)
				.add(Restrictions.ge("cbalance",2000.0))
				.add(Restrictions.like("cname", "张%"))
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
