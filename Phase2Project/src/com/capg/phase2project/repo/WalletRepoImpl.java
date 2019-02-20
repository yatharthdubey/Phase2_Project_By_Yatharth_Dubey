package com.capg.phase2project.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capg.phase2project.bean.Customer;
import com.capg.phase2project.bean.Wallet;
import com.capg.phase2project.util.Util;


public class WalletRepoImpl implements WalletRepo{

	
	private Connection con = Util.getConnection();
			
			
			@Override
			public boolean save(Customer customer)  {
				Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.executeUpdate("INSERT INTO customers VALUES('"+customer.getName()+"',"+customer.getMobileNo()+")");
					stmt.executeUpdate("INSERT INTO wallet VALUES('"+customer.getWallet().getBalance()+"',"+customer.getMobileNo()+")");
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}

			@Override
			public Customer findOne(String mobileNo) {
				try {
				PreparedStatement findc = con.prepareStatement("select name from customers where mobileNo=?");
				PreparedStatement findw = con.prepareStatement("select amount from wallet where mobileNo=?");
				findc.setString(1, mobileNo);
				findw.setString(1, mobileNo);
				ResultSet rs1 = findc.executeQuery();
				ResultSet rs2 = findw.executeQuery();
				rs1.next();
				rs2.next();
				Customer customer = new Customer();
				customer.setName(rs1.getString(1));
				customer.setMobileNo(String.valueOf(mobileNo));
				Wallet wallet = new Wallet(); 
				wallet.setBalance(new BigDecimal(rs2.getDouble(1)));
				customer.setWallet(wallet);
				return customer;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public boolean updateAmount(String mobileNo, BigDecimal amount) {
					
				try {
					PreparedStatement update = con.prepareStatement("update wallet set amount = ? where mobileNo = ?");
					update.setBigDecimal(1, amount);
					update.setLong(2, Long.parseLong(mobileNo));
					update.executeUpdate();
					return true;
				}catch(SQLException s) {
					System.out.println(s);
				}
				return false;
				
			}
			

}
