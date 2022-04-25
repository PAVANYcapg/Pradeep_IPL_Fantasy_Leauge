package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.model.Bidder;

@Repository
public interface BidderDAO {
	
	public void addBidder(Bidder bidder);
	public Bidder findBidder(int id);
	public List<Bidder> findAllBidder();
	public boolean updateBidder(Bidder bidder);
	public boolean deleteBidder(int id);
}