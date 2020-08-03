package com.sun.controller;

import com.sun.dto.EmployeeDTO;
import com.sun.service.EmployeeMgmtService;
import com.sun.vo.EmployeeVO;

public class MainController {
	
	private EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
		
		this.service = service;
	}
	
	public String processEmployee(EmployeeVO vo)throws Exception{
		EmployeeDTO dto=null;
		String result=null;
		//convert  VO class object to DTO class object
				dto=new EmployeeDTO();
				dto.setEname(vo.getEname());
				dto.setEadd(vo.getEadd());
				dto.setbSal(vo.getbSal());
				dto.setDa(vo.getDa());
				dto.setHra(vo.getHra());
				//use service
				result=service.calculateGrassSalary(dto);
				return result;
	}

}
