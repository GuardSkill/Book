package cn.guardskill.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Builddatabase {
 public static void main() throws Exception
 {
	 Configuration con=new Configuration().configure();
	 SessionFactory sf=new con.buildSessionFactory();
	 Session sess=sf.openSession();
	 Transaction tx=sess.beginTransaction();
	 User
	 
 }
}
