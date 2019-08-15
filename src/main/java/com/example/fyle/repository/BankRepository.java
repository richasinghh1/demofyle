/*package com.example.fyle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fyle.model.Banks;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
	@Query(value="SELECT * FROM Banks b WHERE b.id = (select bank_id from bank_branches where ifsc=?1) offset ?2 limit ?3", nativeQuery = true)
	List<Banks> getBankDetails(String iFSCcode, long offset, long limit);
}
*/