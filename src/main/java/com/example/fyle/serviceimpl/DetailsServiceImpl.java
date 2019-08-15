package com.example.fyle.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fyle.model.Banks;
import com.example.fyle.model.Branches;
import com.example.fyle.repository.DetailsRepository;
import com.example.fyle.service.DetailsService;
import com.example.fyle.util.PagedResult;

@Service
public class DetailsServiceImpl implements DetailsService {
	
	@Autowired
	DetailsRepository repository;
	
	@Override
	public PagedResult<Banks> getBankDetails(String iFSCcode, long offset,long limit) {
		List<Banks> resultList= repository.getBankDetails(iFSCcode, offset, limit);
		return new PagedResult<Banks>(resultList,resultList.size(),limit,offset);
	    }
	@Override
	public PagedResult<Branches> getBranchDetails(String name, String city, long offset, long limit) {
		System.out.println(repository.getBranchDetails(name,city, offset, limit));
		List<Branches> resultList= repository.getBranchDetails(name,city, offset, limit);
		return new PagedResult<Branches>(resultList,resultList.size(),limit,offset);
	}
}
