package com.spring.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.domain.Customer;

@Repository
public class CustomerRepository implements ICustomerRepository {
	
	@Autowired
	private DataBaceConnection dataBaceConnection;

	@Override
	public String saveCustomer(Customer customer) {
		String message =null;
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=dataBaceConnection.getConnection();
			pstmt=con.prepareStatement("insert into Customer(cId,cName,cEmailId)values(?,?,?)");
			pstmt.setInt(1,customer.getcId());
			pstmt.setString(2,customer.getcName());
			pstmt.setString(3,customer.getcEmailId());
			pstmt.executeUpdate();
			message= "inserted successfully";
			
		}catch(Exception    ex){
			message= "Exception occured while inserting customer" + ex;
		}finally{
			try {
				dataBaceConnection.closePstmt(pstmt);
				dataBaceConnection.closeConnection(con);
			} catch (SQLException e) {
				message= "Exception occured while closing resources ";
			}
		}
		return message;
	}

	@Override
	public List<Customer> getCustomersByName(String cName) {
		Connection con = null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    Customer customer=null;
	    List<Customer> list= new ArrayList<Customer>();
		try{
			con=dataBaceConnection.getConnection();
			pstmt=con.prepareStatement("select * from Customer where CName=?" );
			pstmt.setString(1,cName);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				customer= new Customer();
				
				customer.setcId(rs.getInt("cId"));
				customer.setcName(rs.getString("cName"));
				customer.setcEmailId(rs.getString("cEmailId"));
				list.add(customer);
			}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				dataBaceConnection.closePstmt(pstmt);
				dataBaceConnection.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	

	@Override
	public String updateCustomerBycId(Customer customer) {
		String message =null;
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
			con=dataBaceConnection.getConnection();
			pstmt=con.prepareStatement("update Customer set cName=?,cEmailId=? where cid=? ");
			pstmt.setString(1,customer.getcName());
			pstmt.setString(2,customer.getcEmailId());
			pstmt.setInt(3,customer.getcId());
			
			pstmt.executeUpdate();
			message= "updated successfully";
			
		}catch(Exception    ex){
			message= "Exception occured while updating customer" + ex;
		}finally{
			try {
				dataBaceConnection.closePstmt(pstmt);
				dataBaceConnection.closeConnection(con);
			} catch (SQLException e) {
				message= "Exception occured while closing resources ";
			}
			
		}
	
		return message;
	}
}
