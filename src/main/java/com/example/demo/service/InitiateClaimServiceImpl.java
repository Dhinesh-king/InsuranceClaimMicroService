package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InitiateClaim;
import com.example.demo.repo.InitiateClaimRepository;

@Service
public class InitiateClaimServiceImpl implements IInitiateClaimService {
	Logger logger=LoggerFactory.getLogger(InitiateClaimServiceImpl.class);
	
	@Autowired
	InitiateClaimRepository icrepo;
	

	@Override
	public InitiateClaim saveClaim(InitiateClaim initiateClaim) {
		logger.info("Saving InitiateClaim Data to the Database..");
		return icrepo.save(initiateClaim);
	}
	
}
