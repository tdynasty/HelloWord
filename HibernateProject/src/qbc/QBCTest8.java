package qbc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import pojo.Customer;
import util.HibernateSessionFactory;

public class QBCTest8 {
	public static void main(String[] args) {
		//多个统计函数
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		//获取准测对象
		Criteria crit=session.createCriteria(Customer.class);
		ProjectionList pl=Projections.projectionList();
		Projection pro=Projections.max("cbalance");
		Projection pro1=Projections.min("cbalance");
		Projection pro2=Projections.count("account");
		Projection pro3=Projections.countDistinct("account");
		Projection pro4=Projections.rowCount();
		pl.add(pro);
		pl.add(pro1);
		pl.add(pro2);
		pl.add(pro3);
		pl.add(pro4);
		crit.setProjection(pl);
		Object[] obj=(Object[]) crit.uniqueResult();

		for(Object ob:obj){
			System.out.println(ob);
		}
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
