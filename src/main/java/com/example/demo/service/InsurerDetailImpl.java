package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.InitiateClaim;
//import com.example.demo.entity.InitiateClaim;
import com.example.demo.entity.InsurerDetail;
import com.example.demo.entity.TreatmentPlan;
import com.example.demo.repo.InsurerDetailRepository;

@Service
public class InsurerDetailImpl implements IInsurerDetailService {

	Logger logger = LoggerFactory.getLogger(InsurerDetailImpl.class);

	@Autowired
	private InsurerDetailRepository idrepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<InsurerDetail> getAllInsurerDetails() {
		return idrepo.findAll();
	}

	@Override
	public InsurerDetail getInsurerByPackageName(String packageName) {
		return idrepo.findByInsurerPackageName(packageName).get();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Double getTotalCost(InitiateClaim initiateClaim) {

		logger.info("Getting the Treatment Plan object from TreatmentPlan Microservice..");

		String url = "http://localhost:8082/treatment/getTreatmentPlanByPatientName/" + initiateClaim.getPatientName();
		TreatmentPlan treatmentPlan = restTemplate.getForObject(url, TreatmentPlan.class);
		logger.info("Successfully obtained TreatmentPlan Object..");

		return treatmentPlan.getCost();
	}
}
