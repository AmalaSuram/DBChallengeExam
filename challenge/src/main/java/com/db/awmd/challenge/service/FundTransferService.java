package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;
import com.db.awmd.challenge.repository.AccountsRepository;
import com.db.awmd.challenge.repository.FundTransferRepository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundTransferService {
	
	@Getter
	 private final FundTransferRepository fundTransferRepository;
	
	

	  @Autowired
	  public FundTransferService(FundTransferRepository fundTransferRepository) {
	    this.fundTransferRepository = fundTransferRepository;
	  }
	
	
	 @Override
		public ResponseFundTransfer transaction(FundTransfer fundTransfer) {
			return this.fundTransferRepository.transaction(fundTransfer);
		}

}
