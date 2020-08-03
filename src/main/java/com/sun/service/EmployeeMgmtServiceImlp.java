package com.sun.service;

import com.sun.bo.EmployeeBO;
import com.sun.dto.EmployeeDTO;
import com.sun.dao.EmployeeDAO;

public class EmployeeMgmtServiceImlp {
	
	private  EmployeeDAO dao;

	public EmployeeMgmtServiceImlp(EmployeeDAO dao) {
		
		this.dao = dao;
	}
	
	public String calculateGrassSalary(EmployeeDTO dto) throws Exception {
		
	    float gSal=0.0f,netSal=0.0f;
	    int deduction = 0;
	    EmployeeBO bo=null;
	    int count=0;
		//calculate Grass_Salary
	    gSal=(dto.getbSal()+dto.getDa()+dto.getHra());
	    //calculate Net_Salary
	    netSal=(gSal)-(deduction);
	    
		//prepare CustomerBO object having persistable data...
	    bo=new EmployeeBO();
	    bo.setEname(dto.getEname());
	    bo.setEadd(dto.getEadd());
	    bo.setGsal(gSal);
	    bo.setNetsal(netSal);
	    
	    //use dAO
	    count=dao.insert(bo);
	    // process the result
	    if(count==0)
	    	  return "Employee Registration failed ";
	    else 
	    	 return "Employee Registration Succeded :: Basic_Salary::"+dto.getbSal()+" DA::"+dto.getDa()+" Hra::"+dto.getHra()+" Total Grass_Salary::"+gSal+"Total Net_Salary::"+netSal;
	}
	

}
