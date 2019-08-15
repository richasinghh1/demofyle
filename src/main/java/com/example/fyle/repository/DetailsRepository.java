package com.example.fyle.repository;

import java.util.List;

import com.example.fyle.model.Banks;
import com.example.fyle.model.Branches;

public interface DetailsRepository {
	
	List<Branches> getBranchDetails(String name, String city, long offset, long limit);
	
	List<Banks> getBankDetails(String iFSCcode, long offset, long limit);
	

}
