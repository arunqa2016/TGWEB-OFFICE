package com.tgweb.hooks;

import java.io.IOException;

import com.tgweb.baseTest.BaseTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest {
	
	//BaseTest Bt = new BaseTest();
	
	public void beforeScenario() throws IOException {
//		System.out.println("---------- HOOKS BEFORE SCENARIO ---------- ");
//		Bt.initialize();
	}

	
	public void afterScenario() {
//		System.out.println("---------- HOOKS AFTER SCENARIO ----------");
//		Bt.EndTest();
	}
}
