package com.db.awmd.challenge.domain;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class FundTransfer {
	private int fromAccount;
	private int toAccount;
	private Double amount;

}
