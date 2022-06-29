package com.cts.calculatenetworth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.calculatenetworth.model.MutualFund;
import com.cts.calculatenetworth.repository.MutualFundRepository;

@SpringBootTest
class MutualFundServiceTest {

	@MockBean
	private MutualFundRepository mutualFundRepository;

	@Autowired
	private MutualFundService mutualFundService;

	MutualFund mutualFund = new MutualFund(21, "CPE", 10);

	@Test
	void testFindByMutualFundName() {
		when(mutualFundRepository.findByMutualFundName("CPE")).thenReturn(mutualFund);
		assertEquals(mutualFund, mutualFundService.findByMutualFundName(mutualFund.getMutualFundName()));
	}

	@Test
	void testDeleteMutalFundl() {
		int mid = 10;
		mutualFundService.deleteMutalFund(mid);
		verify(mutualFundRepository, times(1)).deleteById(mid);

	}

	@Test
	void testUpdateMutualFund() {
		mutualFund.setMutualFundUnits(4);
		mutualFundService.updateMutualFund(mutualFund);
		verify(mutualFundRepository, times(1)).save(mutualFund);

	}

}
