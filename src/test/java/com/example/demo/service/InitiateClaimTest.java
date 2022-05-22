package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.InitiateClaim;

import com.example.demo.repo.InitiateClaimRepository;

@SpringBootTest
public class InitiateClaimTest {

	@MockBean
	private InitiateClaimRepository icrepo;
	
	@Autowired
	private IInitiateClaimService icservice;

	@Test
	public void testSaveInitiateClaim() {
		InitiateClaim initiateClaim = new InitiateClaim(1, "surya", "urology", "package-1", "akalya");
		when(icrepo.save(initiateClaim)).thenReturn(initiateClaim);

		InitiateClaim savedInitiateClaim = icservice.saveClaim(initiateClaim);
		assertThat(savedInitiateClaim).isNotNull();
		Assertions.assertEquals(initiateClaim.getInsurerName(), savedInitiateClaim.getInsurerName());
	}

}
