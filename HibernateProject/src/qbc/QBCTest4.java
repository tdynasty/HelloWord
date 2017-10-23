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
		//查询条件是cname 赵% 或 account 333-555
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		//获取准测对象
		Criteria crit=session.createCriteria(Customer.class);
		//Restrictions返回的是Criterion对象
		Criterion con=Restrictions.or(Restrictions.like("cname", "赵%"), Restrictions.between("account", 222, 555));
		
		//查询条件加入到准测对象当中
		crit.add(con);
		
		List<Customer> list=crit.list();
		
		for(int i=0;i<list.size();i++){
			Customer cus=(Customer)list.get(i);
			System.out.println(cus.getAccount()+cus.getCname()+cus.getPassword()+cus.getCbalance());
		}

	}

}
