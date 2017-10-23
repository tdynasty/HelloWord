package qbc;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest5 {
	public static void main(String[] args) {
		//SQL表达式--姓赵的信息
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		Criteria crit=session.createCriteria(Customer.class);
		
		Criterion con=Restrictions.sqlRestriction("{alias}.cname like ?", "赵%", StringType.INSTANCE);
		Criterion con1=Restrictions.sqlRestriction("{alias}.account < ?", 444, IntegerType.INSTANCE);
		crit.add(con);
		crit.add(con1);
		
		List<Customer> list=crit.list();
		
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
			
		}
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
