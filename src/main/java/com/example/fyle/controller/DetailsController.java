package com.example.fyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fyle.model.Banks;
import com.example.fyle.model.Branches;
import com.example.fyle.service.DetailsService;
import com.example.fyle.util.PagedResult;



@RestController

public class DetailsController {
	
	@Autowired
	DetailsService detailsService;
	
	@GetMapping("/BankDetails")
	public ResponseEntity<Object> BankDetails(@RequestParam(name="IFSCcode") String IFSCcode,@RequestParam(name = "offset") long offset,@RequestParam(name = "limit") long limit) {
	try {
		PagedResult<Banks> resultList=detailsService.getBankDetails(IFSCcode,offset,limit);
	return new ResponseEntity<Object>(resultList, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}		
	}
	
	@GetMapping("/BranchkDetails")
	public ResponseEntity<Object> BranchkDetails(@RequestParam(name="name") String name,@RequestParam(name="city") String city,@RequestParam(name = "offset") long offset,@RequestParam(name = "limit") long limit) {
	try {
		PagedResult<Branches> resultList=detailsService.getBranchDetails(name,city,offset,limit);
	return new ResponseEntity<Object>(resultList, HttpStatus.OK);
	}catch(Exception e) {
		return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}		
	}

}
