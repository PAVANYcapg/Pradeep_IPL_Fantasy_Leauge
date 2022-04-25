package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.LeaderBoard;

@Repository
public interface LeaderBoardDAO {
	
	public void addLeaderBoard(LeaderBoard leaderBoard);
	public LeaderBoard findLeaderBoard(int id);
	public List<LeaderBoard> findAllLeaderBoard();
	public boolean updateLeaderBoard(LeaderBoard leadderBoard);
	public boolean deleteLeaderBoard(int id);
	
	

}
