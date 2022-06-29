package p1;


import org.hibernate.Transaction;
import org.hibernate.Session;

public class MainClass {

	public static void main(String[] args) {
		
		deleteData();
		
	}
	
	public static void saveData() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Transaction t1 = hibernate.beginTransaction();
		
		System.out.println(" 3. Transaction started :- "+t1);
		
		Products p = new Products(2, "Apple",800,5,"Phone");
		hibernate.save(p);
		
		System.out.println(" 4. Data Saved ");
		
		
		t1.commit();
		hibernate.close();
		
		System.out.println(" 5. Database commit & hibernate closed ...");
	}
	
	public static void getData() {
	
		Session hibernate = HibernateUtil.getHibernateLink();
		Products p = (Products) hibernate.get(Products.class, 1);
		System.out.println(p);
		hibernate.close();	
	}
	
	public static void updateData() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Products p = (Products) hibernate.get(Products.class, 1);	
		Transaction t = hibernate.beginTransaction();
		p.setReviewRatings(5);
		t.commit();
		System.out.println(p);
		hibernate.close();	
	}
	
	public static void deleteData() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Transaction t = hibernate.beginTransaction();
		Products p = (Products) hibernate.get(Products.class, 2);
		hibernate.delete(p);
		t.commit();
		hibernate.close();
	}
	
	
}
