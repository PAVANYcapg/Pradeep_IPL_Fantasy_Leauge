package com.controller;

public class FindAllBidderException extends RuntimeException{
	
	public FindAllBidderException() {
		super("Bidder is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Bidder is not avliable in database";
	}

}
