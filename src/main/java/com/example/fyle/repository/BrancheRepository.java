/*package com.example.fyle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fyle.model.Branches;

@Repository
public interface BrancheRepository extends JpaRepository<Branches, Long> {
	
	@Query(value=" Select * from branches where ifsc in (Select ifsc from bank_branches where bank_name =?1 and city=?2)  offset ?3 limit ?4;", nativeQuery = true)
	List<Branches> getBranchDetails(String name, String city, long offset, long limit);


}
*/