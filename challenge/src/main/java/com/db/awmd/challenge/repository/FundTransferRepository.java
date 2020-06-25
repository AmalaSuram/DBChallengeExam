package com.db.awmd.challenge.repository;

import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;
import com.db.awmd.challenge.exception.BankTransactionException;

public interface FundTransferRepository {
	ResponseFundTransfer transaction(FundTransfer fundTransfer)throws BankTransactionException;

}
