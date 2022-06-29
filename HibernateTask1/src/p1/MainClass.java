package p1;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainClass {
	
	public static void main(String[] args) {
		deleteAccount();
	}
	
	public static void saveData() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Transaction t = hibernate.beginTransaction();
		
		Insurance medicalIns = new Insurance(111,"Medical","2022-09-21");
		Insurance carIns = new Insurance(121,"Car","2022-10-22");
		Insurance healthIns = new Insurance(131,"Health","2022-09-18");
		
				
		Account a = new Account(123, "Mike", 64536543);
		a.setMedicalInsurance(medicalIns);
		a.setCarInsurance(carIns);
		a.setHealthInsurance(healthIns);
				
		hibernate.save(a);
		
		t.commit();
		hibernate.close();
	}
	
	public static void updateHealthInsurance() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Account a = (Account) hibernate.get(Account.class, 123);
		
		Transaction t = hibernate.beginTransaction();
		Insurance healthIns = new Insurance(141,"Health","2022-10-18");
		a.setHealthInsurance(healthIns);
		
		t.commit();
		hibernate.close();
		
	}
	
	public static void updateCarInsurance() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Account a = (Account) hibernate.get(Account.class, 123);
		
		Transaction t = hibernate.beginTransaction();
		Insurance carIns = new Insurance(131,"Car","2022-12-24");
		a.setCarInsurance(carIns);
		
		t.commit();
		hibernate.close();
	}
	
	public static void addTransaction() {
		Session hibernate = HibernateUtil.getHibernateLink();
		Account a = (Account) hibernate.get(Account.class, 123);
		
		Transaction t = hibernate.beginTransaction();
		
		Transactions transact = new Transactions("Online Transfer",100,"2022-05-20","paid");
		List<Transactions> allTransactions = new ArrayList<>();
		allTransactions.add(transact);
		
		a.setAllTransactions(allTransactions);
		
		hibernate.save(a);
		
		t.commit();
		hibernate.close();
		
	}
	
	public static void viewTransaction() {
		Session hibernate = HibernateUtil.getHibernateLink();
		Account a = (Account) hibernate.get(Account.class, 123);
		List<Transactions> transaction = a.getAllTransactions();
		for (Transactions tr : transaction) {
		System.out.println(tr.getTransactionType()+"," + tr.getAmount()+","+tr.getDate()+","+tr.getStatus());
		}
		
		hibernate.close();
		
	}
	
	public static void deleteAccount() {
		
		Session hibernate = HibernateUtil.getHibernateLink();
		Account a = (Account) hibernate.get(Account.class, 123);
		Transaction t = hibernate.beginTransaction();
		hibernate.delete(a);
		t.commit();
		hibernate.close();
		
	}
	
	
}
