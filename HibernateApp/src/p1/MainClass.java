package p1;


import org.hibernate.Transaction;
import org.hibernate.Session;

public class MainClass {

	public static void main(String[] args) {
		Session hibernate = HibernateUtil.getHibernateLink();
		Transaction t1 = hibernate.beginTransaction();
	
		System.out.println(" 3. Transaction started :- "+t1);
		
		Products p = new Products(1, "Samsung S10",800,5,"Phone");
		hibernate.save(p);
		
		System.out.println(" 4. Data Saved ");
		
		
		t1.commit();
		hibernate.close();
		
		System.out.println(" 5. Database commit & hibernate closed ...");
	}

}
