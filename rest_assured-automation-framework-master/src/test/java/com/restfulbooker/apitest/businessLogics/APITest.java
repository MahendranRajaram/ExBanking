package com.restfulbooker.apitest.businessLogics;

import org.testng.annotations.Test;

import com.restfulbooker.apitest.actions.ValidatorOperation;
import com.restfulbooker.apitest.baseAPI.Auth;
import com.restfulbooker.apitest.listeners.ExtentBase;
import com.restfulbooker.apitest.listeners.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import java.lang.reflect.Method;

public class APITest extends ExtentBase{
	
  String response;

  @Test
  public void createUser(Method method) {
	 try { 
	  Auth response = new Auth();
	  response.createUserReq();

		  response.assertIt(200);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
		  
		  response.assertIt("AccountNo","",ValidatorOperation.NOT_EMPTY);
		  response.assertIt("AccountType","Savings",ValidatorOperation.EQUALS);
		  response.assertIt("Status","Active",ValidatorOperation.EQUALS);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value == Bad credentials");
	  }
	  catch(AssertionError e){
		  System.err.println(e.getMessage());
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
	  }	 
	  
	 }
  
  @Test
  public void Deposit(Method method) {
		 try { 
		  Auth response = new Auth();
		  response.deposit();

			  response.assertIt(200);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
			   response.assertIt("AccountNo","",ValidatorOperation.NOT_EMPTY);
			  response.assertIt("AmountToBeDeposited","",ValidatorOperation.NOT_EMPTY);
			  response.assertIt("AccountHolderName","MahendranR",ValidatorOperation.EQUALS);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value == Bad credentials");
              
			  System.out.println("Deposit function success");
		  }
		  catch(AssertionError e){
			  System.err.println(e.getMessage());
				  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
		  }	 
		  
		 }
  
  @Test
  public void Get_Balance(Method method) {
		 try { 
		  Auth response = new Auth();
		  response.Get_Balance();

			  response.assertIt(200);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
			  
			  response.assertIt("AccountNumber","",ValidatorOperation.NOT_EMPTY);
			  response.assertIt("AvailableBalance","1000EUR",ValidatorOperation.EQUALS);
			  response.assertIt("AccountHoldername","MahendranR",ValidatorOperation.EQUALS);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value == Bad credentials");
					  }
		  catch(AssertionError e){
			  System.err.println(e.getMessage());
				  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
		  }	 
		  
		 }
  
}
