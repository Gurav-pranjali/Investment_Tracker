package com.cts.dailymutualfundnav.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.mutualfund.model.MutualFund;

@SpringBootTest
class MutualFundTest {

	MutualFund mf = new MutualFund();
	MutualFund mf1 = new MutualFund(10, "CTE", 12);

	@Test
	void testGetMutualFundId() {
		mf.setMutualFundId(10);
		assertEquals(10, mf.getMutualFundId());
	}

	@Test
	void testGetMutualFundName() {
		mf.setMutualFundName("GGE");
		assertEquals("GGE", mf.getMutualFundName());
	}

	@Test
	void testGetMutualFundValue() {
		mf.setMutualFundValue(12);
		assertEquals(12, mf.getMutualFundValue());
	}

	@Test
	void testSetMutualFundId() {
		mf.setMutualFundId(11);
		assertEquals(11, mf.getMutualFundId());
	}

	@Test
	void testSetMutualFundName() {
		mf.setMutualFundName("GGE");
		assertEquals("GGE", mf.getMutualFundName());
	}

	@Test
	void testSetMutualFundValue() {
		mf.setMutualFundValue(12);
		assertEquals(12, mf.getMutualFundValue());
	}

	void testToString() {
		MutualFund mf = new MutualFund(11, "abc", 100.0);
		assertEquals("MutualFund [mutualFundId=11, mutualFundName=abc, mutualFundValue=100.0]", mf.toString());
	}
}
