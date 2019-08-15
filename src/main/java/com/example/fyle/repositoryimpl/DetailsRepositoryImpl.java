package com.example.fyle.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.fyle.model.Banks;
import com.example.fyle.model.Branches;
import com.example.fyle.repository.DetailsRepository;

@Repository
public class DetailsRepositoryImpl implements DetailsRepository {

	@Autowired
	private EntityManager em;
	@SuppressWarnings("unchecked")

	@Override
	public List<Branches> getBranchDetails(String name, String city, long offset, long limit) {
		String query = "Select * from branches where ifsc in (Select ifsc from bank_branches where city= :city AND bank_name= :name)";
		Query nativeQuery = em.createNativeQuery(query);
		//Paginering
		nativeQuery.setParameter("name", name);
		nativeQuery.setParameter("city", city);
		nativeQuery.setFirstResult((int) offset);
		nativeQuery.setMaxResults((int) limit);
		@SuppressWarnings("unchecked")
		List<Branches> resultList = nativeQuery.getResultList();
		return resultList;
	}

	@Override
	public List<Banks> getBankDetails(String iFSCcode, long offset, long limit) {
		String query = "Select * from banks where id = (Select bank_id from bank_branches where ifsc= :ifsc)";
		Query nativeQuery = em.createNativeQuery(query);
		nativeQuery.setParameter("ifsc", iFSCcode);
		nativeQuery.setFirstResult((int) offset);
		nativeQuery.setMaxResults((int) limit);
		@SuppressWarnings("unchecked")
		List<Banks> resultList = nativeQuery.getResultList();
		return resultList;
	}

}
