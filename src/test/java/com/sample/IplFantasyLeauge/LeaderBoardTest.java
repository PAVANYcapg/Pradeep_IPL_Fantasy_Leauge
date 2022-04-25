package com.sample.IplFantasyLeauge;



import java.sql.Date;
import java.util.List;

import org.hibernate.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.LeaderBoardService;
import com.model.LeaderBoard;

import junit.framework.Assert;

@SpringBootTest
class LeaderBoardTest {
	
	@Autowired
	LeaderBoardService leaderBoardService;
	
	@Test
	void testAdd() {
		LeaderBoard leaderBoard = new LeaderBoard();
		leaderBoard.setBidsParticipated(1);
		leaderBoard.setBidsWon(10);
		leaderBoard.setBidsLost(5);
		leaderBoard.setPercentile(65.2);
		leaderBoard.setBidder_ranking(1);
		leaderBoardService.add(leaderBoard);

		LeaderBoard to_be_tested = leaderBoardService.findLeaderBoard(leaderBoard.getBidderId());
		Assert.assertEquals(1, to_be_tested.getBidderId());

		Assert.assertEquals(1, to_be_tested.getBidsParticipated());

	}

	@Test
	void testFindLeaderBoard() {
		LeaderBoard leaderBoard1 = new LeaderBoard();
		leaderBoard1.setBidsParticipated(2);
		leaderBoard1.setBidsWon(2);
		leaderBoard1.setBidsLost(6);
		leaderBoard1.setPercentile(78.2);
		leaderBoard1.setBidder_ranking(3);
		leaderBoardService.add(leaderBoard1);
		
		LeaderBoard to_be_tested =leaderBoardService.findLeaderBoard(1); 
		Assert.assertEquals(1, to_be_tested.getBidsParticipated());
	}

	@Test
	void testFindAllLeaderBoard() {
		LeaderBoard leaderBoard2 = new LeaderBoard();
		leaderBoard2.setBidsParticipated(5);
		leaderBoard2.setBidsWon(15);
		leaderBoard2.setBidsLost(8);
		leaderBoard2.setPercentile(75.2);
		leaderBoard2.setBidder_ranking(5);
		leaderBoardService.add(leaderBoard2);
		
		List<LeaderBoard>leaderBoardlist = leaderBoardService.findAllLeaderBoard();
		Assert.assertEquals(3, leaderBoardlist.size());

	}

	@Test
	void testUpdate() {
		//LeaderBoard leaderBoard4 = leaderBoardService.findItem(2);
		//leaderBoard4.setBidsWon(13);
		//leaderBoardService.update(leaderBoard4);
		
		LeaderBoard leaderBoard3=leaderBoardService.findLeaderBoard(3);
		leaderBoard3.setBidsParticipated(5);
//		leaderBoard3.setBidsWon(11);
//		leaderBoard3.setBidsLost(5);
//		leaderBoard3.setPercentile(75.2);
//		leaderBoard3.setBidder_ranking(7);
//		
		leaderBoardService.update(leaderBoard3);
		

     //   LeaderBoard leaderBoard4=leaderBoardService.findItem(1);
		Assert.assertEquals(5, leaderBoard3.getBidsParticipated());
		
		
		}

	@Test
	void testDelete() {
		LeaderBoard leaderBoard=leaderBoardService.findLeaderBoard(2);
		leaderBoardService.delete(leaderBoard.getBidderId());
		LeaderBoard leaderBoard2=leaderBoardService.findLeaderBoard(leaderBoard.getBidderId());
       Assert.assertNull(leaderBoard2);
       
      // boolean isDelete= leaderBoardService.delete(2);
       //Assert.assertEquals(true,isDelete);
	}

}
