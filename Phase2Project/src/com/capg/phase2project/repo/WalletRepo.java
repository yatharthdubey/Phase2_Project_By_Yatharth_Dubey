package com.capg.phase2project.repo;

import java.math.BigDecimal;

import com.capg.phase2project.bean.Customer;
import com.capg.phase2project.exception.DuplicateMobileNumberException;
import com.capg.phase2project.exception.MobileNumberNotFoundException;

public interface WalletRepo {
	
	boolean save(Customer customer) throws DuplicateMobileNumberException;
	
	Customer findOne(String mobileNo) throws MobileNumberNotFoundException;
	
	boolean updateAmount(String mobileNo, BigDecimal amount);
	 
}