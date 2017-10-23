package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojo.Customer;

public class HibTest {


	public static void main(String[] args) {
		Customer cus=new Customer();
		/*��HibernateSessionFactory���Ѿ�д�� ������д
		 * 
		//��ȡ�����ļ�������ӳ���ļ�.hbm.xml�� ����Hibernate configure()���Զ�xml�ļ�
		//����Hibnate
		Configuration conf = new Configuration().configure();
		//����SessionFactory �ж�������  ��һ�����ã�����session
		SessionFactory sf = conf.buildSessionFactory();
		//��Session ִ��CRUD����    Hibernate�е�Session �൱������ ����HttpServlet�е�Session   ��Ϊһ������
		Session session=sf.openSession();
		*/
		
		//����ǰ����
		Session session=HibernateSessionFactory.getSession();
		//�����������
		Transaction tran=session.beginTransaction();
		
		//���һ������
//		cus.setAccount(222);
//		cus.setPassword("qwe");
//		cus.setCname("����");
//		cus.setCbalance(3000);
//		session.save(cus);
		//session.saveOrUpdate(cus);������ݿ�����idΪ222��������ô���޸���Ϣ
		
		//���췽���������
		
		//�޸�
		//getload����id(account) ����update����
//		cus=(Customer)session.get(Customer.class, 222);
//		cus.setCbalance(cus.getCbalance()+1000);
//		session.update(cus);
		
		
		//ɾ��
//		cus=(Customer)session.get(Customer.class,222);
//		session.delete(cus);
		
		//��ѯһ������ ֻ�ܲ�id ��Ϊ�������ļ���<property>
		cus=(Customer)session.get(Customer.class, 222);
		System.out.println(cus.getAccount());
		System.out.println(cus.getPassword());
		System.out.println(cus.getCname());
		System.out.println(cus.getCbalance());
		
		//session.save()��ȥ֮����Ҫtran�ύ
		
		//�ύ����
		tran.commit();
		//�ر�Session
		HibernateSessionFactory.closeSession();
	}

}
