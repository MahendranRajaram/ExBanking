package com.restfulbooker.apitest.baseAPI;

import com.restfulbooker.apitest.actions.HttpOperation;
import com.restfulbooker.apitest.restassuredFuntions.API;

public class Auth extends API{
     
	/**
     * Creating the User Request using API calls
     * 
     * */
public String createUserReq() {
		initBase("Host");
		init("/create_user", HttpOperation.POST);
		setHeader("Content-Type","application/json");
		setBody("{\n" + 
				"    \"FirstName\":\"Mahendran\",\n" + 
				"    \"LastName\":\"R\",\n" + 
				"    \"DOB\":\"28/07/1996\",\n" + 
				"    \"Email\":\"test@yolo.com\",\n" + 
				"    \"PhoneNo\":\"123456789\",\n" + 
				"    \"Address\":\"28 part town, India\",\n" + 
				"    \"UserName\":\"admin\",\n" + 
				"    \"Password\":\"admin\",\n" + 
				"    \"AccountType\":\"savings\",\n" + 
				"    \"IntialDepositAmt\":\"1000\",\n" + 
				"    \"IdentityDocuments\":\"123\"\n" + 
				"}");
		String response = callIt();
		return response;
	}

/**
 * Deposit using API calls
 * 
 * */
	public String deposit() {
		initBase("Host");
		init("/deposit", HttpOperation.POST);
		setHeader("Content-Type","application/json");
		setBody("{\n" + 
				"  \"AccountHolderName\":\"MahendranR\",\n" + 
				"  \"AccountNumber\" : 98080830803048,\n" + 
				"  \"AmountToBeDepostied\" :\"1000 EUR\"\n" + 
				"}"); 
		String response = callIt();
		return response;
	}
	
	/**
     * Get balance Request using API calls
     * 
     * */
	public String Get_Balance() {
		initBase("Host");
		init("/get_balance", HttpOperation.GET);
		setHeader("Content-Type","application/json");
		setBody("{\n" + 
				"  \"account_number\": \"1234567890\",\n" + 
				"   \"Bank name\":\"Ex-Bank\",\n" + 
				"   \"IFSC Code\":\"BANK001\",\n" + 
				"   \"user name\":\"MahendranR\",\n" + 
				"   \"Password\":\"MahendranR\"\n" + 
				"}\n" + 
				"");
		String response = callIt();
		return response;
	}
}
