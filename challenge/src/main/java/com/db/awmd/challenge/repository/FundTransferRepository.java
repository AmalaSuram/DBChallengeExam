package com.db.awmd.challenge.repository;

import com.db.awmd.challenge.dto.FundTransfer;
import com.db.awmd.challenge.dto.ResponseFundTransfer;

public interface FundTransferRepository {
	ResponseFundTransfer transaction(FundTransfer fundTransfer);

}
