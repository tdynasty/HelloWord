package qbc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest9 {

	public static void main(String[] args) {
		//投影查询--查询account大于等于222的cname
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		//获取准测对象
		Criteria crit=session.createCriteria(Customer.class);
		crit.setProjection(Property.forName("cname"));
		crit.add(Restrictions.ge("account", 222));
		List<String> list=crit.list();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		

		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
