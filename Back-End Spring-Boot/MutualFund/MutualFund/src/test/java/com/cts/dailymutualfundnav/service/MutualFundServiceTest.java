package com.cts.dailymutualfundnav.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.mutualfund.exception.MutualFundNotFoundException;
import com.cts.mutualfund.model.MutualFund;
import com.cts.mutualfund.repository.MutualFundRepository;
import com.cts.mutualfund.service.MutualFundService;

@SpringBootTest
class MutualFundServiceTest {

	@MockBean
	private MutualFundRepository mutualFundRepository;

	@Autowired
	private MutualFundService mutualFundService;

	MutualFund m1 = new MutualFund(11, "GLE", 120000.00);
	

	MutualFund m2 = new MutualFund(12, "YDS", 120000.00);
	List<MutualFund> record=new ArrayList<>(Arrays.asList(m1,m2));

	@Test
	void testGetByMutualFundName() throws MutualFundNotFoundException {
		Mockito.when(mutualFundRepository.findByMutualFundName("GLE")).thenReturn(m1);
		assertEquals(m1, mutualFundService.getByMutualFundName("GLE"));
		status().isOk();

	}
	@Test
	void testfindAll() throws MutualFundNotFoundException  {
		Mockito.when(mutualFundRepository.findAll()).thenReturn(record);
		assertEquals(record, mutualFundService.getAll());
		status().isOk();

	}
}
