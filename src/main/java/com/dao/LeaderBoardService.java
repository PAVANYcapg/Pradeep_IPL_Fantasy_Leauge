package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.LeaderBoard;

@Service
public class LeaderBoardService {
	
	@Autowired
	LeaderBoardDAO leaderboardimpl;
	
	public void add(LeaderBoard leaderBoard) {
		leaderboardimpl.addLeaderBoard(leaderBoard);
	}
	
	public LeaderBoard findLeaderBoard(int id) {
		return leaderboardimpl.findLeaderBoard(id);
	}
	
	public List<LeaderBoard> findAllLeaderBoard() {
		return leaderboardimpl.findAllLeaderBoard();
	}
	
	public boolean update(LeaderBoard leaderBoard) {
		return leaderboardimpl.updateLeaderBoard(leaderBoard);
	}
	
	public boolean delete(int id) {
		return leaderboardimpl.deleteLeaderBoard(id);
	}
	
}
