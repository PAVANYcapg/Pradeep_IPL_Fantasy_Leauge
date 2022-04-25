package com.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



import com.model.Bidder;

@Service
public class BidderService {


		@Autowired
		BidderDAO bidderdaoimpl;
		
		public void add(Bidder bidder) {
			bidderdaoimpl.addBidder(bidder);
		}
		
		public Bidder findBidder(int id) {
			return bidderdaoimpl.findBidder(id);
		}
		
		public List<Bidder> findAllBidder() {
			return bidderdaoimpl.findAllBidder();
		}
		
		public boolean update(Bidder bidder) {
			return bidderdaoimpl.updateBidder(bidder);
		}
		
		public boolean delete(int id) {
			return bidderdaoimpl.deleteBidder(id);
		}

}