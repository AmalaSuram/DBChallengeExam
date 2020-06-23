package com.db.awmd.challenge.web;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.db.awmd.challenge.service.AccountsService;
import com.db.awmd.challenge.service.FundTransferService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/transactions")
@Slf4j

public class FundTransferController {
	@Autowired
	 private final FundTransferService fundTransferService;
	
	 @PostMapping("/fundtransfer")
		public ResponseEntity<ResponseFundTransfer> transaction(@RequestBody FundTransfer fundTransfer) {

			ResponseFundTransfer responseFundTransfer = fundTransferService.transaction(fundTransfer);
			return new ResponseEntity<>(responseFundTransfer, HttpStatus.OK);
		}
	  

}
