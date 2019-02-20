package com.capg.phase2project.service;

import java.math.BigDecimal;

import com.capg.phase2project.bean.Customer;
import com.capg.phase2project.exception.DuplicateMobileNumberException;
import com.capg.phase2project.exception.InsufficientWalletBalanceException;
import com.capg.phase2project.exception.MobileNumberNotFoundException;

public interface WalletService {

	Customer createAccount(String name, String mobileNo, BigDecimal balance) throws DuplicateMobileNumberException;

	Customer showBalance(String mobileNo) throws MobileNumberNotFoundException;

	Customer[] fundTransfer(String sourceMobileNo, String targetMobileno, BigDecimal amount) throws InsufficientWalletBalanceException, MobileNumberNotFoundException;

	Customer depositAmount(String mobileNo, BigDecimal amount) throws MobileNumberNotFoundException;

	Customer withdrawAmount(String mobileNo, BigDecimal amount) throws MobileNumberNotFoundException, InsufficientWalletBalanceException;

}