package cn.guardskill.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.guardskill.orm.Book;
import cn.guardskill.orm.Info;
import cn.guardskill.orm.User;

public class Builddatabase {
 public static void main(String argv[]) throws Exception
 {
	 Configuration conf=new Configuration().configure();
	 SessionFactory sf=conf.buildSessionFactory();
	 Session sess=sf.openSession();
	 Transaction tx=sess.beginTransaction();
	 User u1=new User();
	 u1.setuEmail("429742@qq.com");
	 u1.setuName("admin");
	 u1.setuPassword("admin");
	 sess.save(u1);
	 Book b1=new Book();
	 b1.setbName("高等数学");
	 sess.save(b1);
	 Info i1=new Info();
	 i1.setiBook(b1);
	 i1.setiUser(u1);
	 sess.persist(i1);
	tx.commit();
	sess.close();
	sf.close();
 }
}
