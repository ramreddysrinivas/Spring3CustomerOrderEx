package com.spring.jdbc.repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaceConnection {
	
	@Value("${db.host.url}")
	private String host;
	
	@Value("${db.port.number}")
	private String port;
	
	@Value("${db.service.name}")
	private String service;
	
	@Value("${db.user}")
	private String userName;
	
	@Value("${db.password}")
	private String password;
	
	public  Connection getConnection() throws ClassNotFoundException,SQLException {
		String hostUrl="jdbc:oracle:thin:@" + host + ":" + Integer.valueOf(port) + ":" + service;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(hostUrl , userName, password);
	}
	
	public  void closeStmt(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}
	public  void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
	public  void closeRs(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
	public  void closePstmt(PreparedStatement pstmt) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
		}
	}
}
