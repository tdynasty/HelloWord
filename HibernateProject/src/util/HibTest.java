package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Customer;

public class HibTest {


	public static void main(String[] args) {
		Customer cus=new Customer();
		/*在HibernateSessionFactory中已经写好 不用再写
		 * 
		//读取配置文件（加载映射文件.hbm.xml） 启动Hibernate configure()可以读xml文件
		//启动Hibnate
		Configuration conf = new Configuration().configure();
		//生成SessionFactory 叫二级缓存  第一个作用：生成session
		SessionFactory sf = conf.buildSessionFactory();
		//打开Session 执行CRUD操作    Hibernate中的Session 相当于连接 不是HttpServlet中的Session   称为一级缓存
		Session session=sf.openSession();
		*/
		
		//代替前三步
		Session session=HibernateSessionFactory.getSession();
		//创建事务对象
		Transaction tran=session.beginTransaction();
		
		//添加一条数据
//		cus.setAccount(222);
//		cus.setPassword("qwe");
//		cus.setCname("李四");
//		cus.setCbalance(3000);
//		session.save(cus);
		//session.saveOrUpdate(cus);如果数据库中有id为222的数据那么就修改信息
		
		//构造方法添加数据
		
		//修改
		//getload查找id(account) 在用update方法
//		cus=(Customer)session.get(Customer.class, 222);
//		cus.setCbalance(cus.getCbalance()+1000);
//		session.update(cus);
		
		
		//删除
//		cus=(Customer)session.get(Customer.class,222);
//		session.delete(cus);
		
		//查询一条数据 只能查id 因为在配置文件里<property>
		cus=(Customer)session.get(Customer.class, 222);
		System.out.println(cus.getAccount());
		System.out.println(cus.getPassword());
		System.out.println(cus.getCname());
		System.out.println(cus.getCbalance());
		
		//session.save()进去之后需要tran提交
		
		//提交事务
		tran.commit();
		//关闭Session
		HibernateSessionFactory.closeSession();
	}

}
