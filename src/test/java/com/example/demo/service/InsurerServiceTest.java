package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.InsurerDetail;

import com.example.demo.repo.InsurerDetailRepository;

@SpringBootTest
public class InsurerServiceTest {
	@MockBean
	private InsurerDetailRepository irepo;

	@Autowired
	private IInsurerDetailService iservice;

	@Test
	public void testGetAllInsurerDetails() {
		List<InsurerDetail> list = new ArrayList<InsurerDetail>();
		InsurerDetail detail1 = new InsurerDetail(1, "varun", "Health Policy", 90000.00, 1);
		InsurerDetail detail2 = new InsurerDetail(2, "Aju", "Health insurance policy for heart", 200000.00, 1);
		list.add(detail1);
		list.add(detail2);
		when(irepo.findAll()).thenReturn(list);
		List<InsurerDetail> allDetails = iservice.getAllInsurerDetails();
		System.out.println(allDetails);
		Assertions.assertEquals(2, allDetails.size());
	}

	@Test
	public void testGetInsurerByPackageName() {
		String insurerPackageName = "Health Policy";
		Optional<InsurerDetail> detail = Optional.of(new InsurerDetail(1, "varun", insurerPackageName, 90000.00, 1));
		when(irepo.findByInsurerPackageName(insurerPackageName)).thenReturn(detail);
		InsurerDetail insurerByPackageName = iservice.getInsurerByPackageName(insurerPackageName);
		Assertions.assertNotNull(insurerByPackageName);
		Assertions.assertEquals(detail.get().getInsurerPackageName(), insurerByPackageName.getInsurerPackageName());
	}

}
