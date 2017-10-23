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
		//统计函数
		
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//查询Customer全部数据
		//获取准测对象
		Criteria crit=session.createCriteria(Customer.class);
		//统计cbalance平均值
		//Projections相当于工厂 创建对象
		//Projection po=Projections.avg("cbalance");
		//crit.setProjection(po);
		//Double avgcbalance=(Double) crit.uniqueResult();
		//统计函数加入到准测对象当中
		//统计从balance的最大值
		Projection po1=Projections.max("cbalance");
		crit.setProjection(po1);
		Double maxcbalance=(Double) crit.uniqueResult();
		
		//System.out.println(avgcbalance);
		System.out.println(maxcbalance);
		
		tran.commit();
		HibernateSessionFactory.closeSession();
	}

}
