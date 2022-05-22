package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.InsurerDetail;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class InsurerDetailRepositoryTest {

	@Autowired
	private InsurerDetailRepository irepo;

	@Test
	@Rollback
	@Order(1)
	public void testSaveInsurerDetail() {
		InsurerDetail insurerDetail = new InsurerDetail(1, "Sundar", "Silver health", 12000.0, 2);
		InsurerDetail savedInsurerDetail = irepo.save(insurerDetail);
		Assertions.assertNotNull(savedInsurerDetail);
		Assertions.assertEquals("Silver health", savedInsurerDetail.getInsurerPackageName());
	}

	@Test
	@Order(2)
	public void testGetAllInsurerDetails() {
		List<InsurerDetail> allInsurerDetails = irepo.findAll();
		Assertions.assertEquals(3, allInsurerDetails.size());
	}

	@Test
	@Order(3)
	public void testFindByInsurerPackageNameWhenPresent() {
		String packageName = "packageName1";
		Optional<InsurerDetail> insurerDetail = irepo.findByInsurerPackageName(packageName);
		Assertions.assertTrue(insurerDetail.isPresent());
	}

	@Test
	@Order(4)
	public void testFindByInsurerPackageNameWhenNotPresent() {
		String packageName = "Golden health";
		Optional<InsurerDetail> insurerDetail = irepo.findByInsurerPackageName(packageName);
		Assertions.assertFalse(insurerDetail.isPresent());
	}

}
