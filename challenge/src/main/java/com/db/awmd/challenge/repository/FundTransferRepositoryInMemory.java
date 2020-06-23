package com.db.awmd.challenge.repository;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;
import com.db.awmd.challenge.service.EmailNotificationService;
import com.db.awmd.challenge.exception.DuplicateAccountIdException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

public class FundTransferRepositoryInMemory implements FundTransferRepository   {

	
	@Transactional(propagation = Propagation.MANDATORY )
	public void addAmount(Long id, double amount) throws BankTransactionException {
		
		EmailNotificationService emailNotificationService=new EmailNotificationService();
	    Account account = this.getAccount(accountId);
	    if (account == null) {
	        throw new BankTransactionException("Account not found " + accountId);
	    }
	    double newBalance = account.getBalance() + amount;
	    if (account.getBalance() + amount < 0) {
	        throw new BankTransactionException(
	                "The money in the account '" + accountId + "' is not enough (" + account.getBalance() + ")");
	       
	    }
	    account.setBalance(newBalance);
	    emailNotificationService.notifyAboutTransfer(account, "Amount Transfered..");
	   
	}
	@Override
	public ResponseFundTransfer transaction(FundTransfer fundTransfer) {
		addAmount(fundTransfer.getToAccount(), fundTransfer.getAmount());
	    addAmount(fundTransfer.getFromAccount(), fundTransfer.getAmount());
		
	    ResponseFundTransfer responseFundTransfer = new ResponseFundTransfer();
		responseFundTransfer.setMessage("transaction succsess");
		responseFundTransfer.setStatusCode(HttpStatus.CREATED.value());
		return responseFundTransfer;
	}
	
	  
	
}
