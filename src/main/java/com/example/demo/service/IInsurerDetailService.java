package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InitiateClaim;
import com.example.demo.entity.InsurerDetail;

public interface IInsurerDetailService {
	
	public List<InsurerDetail> getAllInsurerDetails();
	public InsurerDetail getInsurerByPackageName(String packageName);
	public Double getTotalCost(InitiateClaim initiateClaim);
	
}
