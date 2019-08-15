package com.example.fyle.service;

import com.example.fyle.model.Banks;
import com.example.fyle.model.Branches;
import com.example.fyle.util.PagedResult;

public interface DetailsService {
	PagedResult<Banks> getBankDetails(String iFSCcode, long offset, long limit);

	PagedResult<Branches> getBranchDetails(String name, String city, long offset, long limit);

}
