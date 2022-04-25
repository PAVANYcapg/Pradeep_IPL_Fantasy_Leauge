package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Bidder;
import com.model.LeaderBoard;

@Component
public class LeaderBoardDAOImpl implements LeaderBoardDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addLeaderBoard(LeaderBoard leaderBoard) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(leaderBoard);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public LeaderBoard findLeaderBoard(int id) {
		Session session = sessionFactory.openSession();
		LeaderBoard leaderboard = session.find(LeaderBoard.class, id); 
		session.close();
		return leaderboard;
	}

	@Override
	public List<LeaderBoard> findAllLeaderBoard() {
		Session session = sessionFactory.openSession();
		List<LeaderBoard> leaderboard=session.createQuery("select i from LeaderBoard i").list();
		return leaderboard;
	}

	@Override
	public boolean updateLeaderBoard(LeaderBoard leaderBoard) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(leaderBoard);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteLeaderBoard(int  id) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		LeaderBoard leaderBoard=session.find(LeaderBoard.class,id);
		session.delete(leaderBoard);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	
}
