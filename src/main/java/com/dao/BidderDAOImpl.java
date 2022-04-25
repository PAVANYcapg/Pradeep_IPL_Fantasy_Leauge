package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Bidder;

@Component
public class BidderDAOImpl implements BidderDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addBidder(Bidder bidder) {
		// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(bidder);
			session.flush();
			session.getTransaction().commit();
			session.close();
		
	}

	@Override
	public Bidder findBidder(int id) {
			Session session = sessionFactory.openSession();
			Bidder bidder = session.get(Bidder.class, id); 
			return bidder;
	}

	@Override
	public List<Bidder> findAllBidder() {
		// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			List<Bidder> bidder=session.createQuery("select i from Bidder i").list();
			return bidder;
	}

	@Override
	public boolean updateBidder(Bidder bidder) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(bidder);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteBidder(int id) {
			Session session = sessionFactory.openSession();
			Bidder bidder=session.find(Bidder.class,id);
			session.getTransaction().begin();
			session.delete(bidder);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return true;
	}
	
	
}