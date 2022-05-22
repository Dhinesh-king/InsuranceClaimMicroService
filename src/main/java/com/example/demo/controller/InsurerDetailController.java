package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InitiateClaim;
import com.example.demo.entity.InsurerDetail;
import com.example.demo.service.IInsurerDetailService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/insurer")
public class InsurerDetailController {

	Logger logger = LoggerFactory.getLogger(InsurerDetailController.class);

	@Autowired
	private IInsurerDetailService detailSer;

	@GetMapping(value = "/allInsurerDetails")
	@ApiOperation(value = "this endpoint is used for getting all insurer details")
	public ResponseEntity<List<InsurerDetail>> getAllInsurerDetails() {

		logger.info("The List of All the insurers are being sent back to the Client");

		return new ResponseEntity<List<InsurerDetail>>(detailSer.getAllInsurerDetails(), HttpStatus.OK);
	}

	@GetMapping(value = "/getInsurerPackageName/{insurerPackageName}")
	@ApiOperation(value = "this endpoint is used for getting insurer detail by insurer package name ")
	public ResponseEntity<InsurerDetail> getInsurerPackageName(@PathVariable String insurerPackageName) {

		logger.info("The Insurer with the given name is being sent back to the Client");

		return new ResponseEntity<InsurerDetail>(detailSer.getInsurerByPackageName(insurerPackageName), HttpStatus.OK);
	}

	@PostMapping(value = "/initiateClaim")
	@ApiOperation(value = "this endpoint is used for getting balace amount to be paid")
	public ResponseEntity<String> saveClaim(@RequestBody InitiateClaim initiateClaim) {

		Double totalCost = detailSer.getTotalCost(initiateClaim);
		InsurerDetail insurer = detailSer.getInsurerByPackageName(initiateClaim.getTreatmentPackageName());
		Double insuranceAmount = insurer.getInsuranceAmountLimit();
		Double balance = totalCost - insuranceAmount;

		logger.info("Successfully Initiated the Insurance Claim and sending back the Balance amount to be paid..");

		return new ResponseEntity<>("The balance to be paid is " + balance, HttpStatus.OK);
	}

}
