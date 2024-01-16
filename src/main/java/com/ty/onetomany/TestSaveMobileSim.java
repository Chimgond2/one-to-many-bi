package com.ty.onetomany;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		Mobile mobile=new Mobile();
		mobile.setName("nokia");
		mobile.setCost(25000);
		
		Sim sim1=new Sim();
		sim1.setProvider("vodfone");
		sim1.setType("3g");
		sim1.setImei("12gh");
		
		Sim sim2=new Sim();
		sim2.setProvider("airtel5");
		sim2.setType("3g");
		sim2.setImei("12gh");
		
		Sim sim3=new Sim();
		sim3.setProvider("airtel7");
		sim3.setType("3g");
		sim3.setImei("12gh");
		
		List<Sim> list=new ArrayList<Sim>();
		list.add(sim1);
		list.add(sim2);
		list.add(sim3);
		
		sim1.setMobile(mobile);
		sim2.setMobile(mobile);
		sim3.setMobile(mobile);
		
		entityTransaction.begin();
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		
		entityTransaction.commit();

		
		
	}

}
