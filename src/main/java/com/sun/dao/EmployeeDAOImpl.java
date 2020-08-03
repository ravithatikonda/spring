package com.sun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.sun.bo.EmployeeBO;

public class EmployeeDAOImpl {

	private  static final  String   CUSTOMER_INSERT_QUERY="INSERT INTO EMP_REG VALUES(ENO_SEQ1.NEXTVAL,?,?,?,?)";
	private  DataSource ds;
	public EmployeeDAOImpl(DataSource ds) {
		
		this.ds = ds;
	}
	
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get pooled jdbc connection
		con=ds.getConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
		//set values to query params
	    ps.setString(1,bo.getEname());
	    ps.setString(2, bo.getEadd());
	    ps.setFloat(3, bo.getGsal());
	    ps.setFloat(4,bo.getNetsal());
	    
		//execute the SQL query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
		
	}
	
}
