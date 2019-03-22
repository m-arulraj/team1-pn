package com.professionalNetworking.postService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.professionalNetworking.postService.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	
	@Modifying
	@Query("update Company c set c.name=:name where c.id=:id")
	public int updateCompany (@Param("id") Long id,@Param("name") String name);

}
